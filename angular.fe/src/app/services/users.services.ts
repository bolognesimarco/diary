import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { User } from '../model/user.model';
import { SchoolClass } from '../model/schoolclass.model';

@Injectable()
export class UserService {

    private headers = new Headers({ 'Content-Type': 'application/json' });
    private usersUrl: string = 'api/users/';
    private user: User;


    constructor(private http: Http) { }

    public userById(id: number): Observable<User> {
        return this.http
            .get(
                this.usersUrl + '/' + id,
                {headers: this.headers}
            )
            .map(
                res => res.json().data as User
            );
    }

    public login(username: string, password: string): Observable<User> {
        return this.http
            .get(
                this.usersUrl + '?username=' + username + '&password=' + password,
                {headers: this.headers}
            )
            .map(
                res => {
                    let returned: User = res.json() as User;

                    if (returned) {
                        this.user = returned;
                    } else {
                        this.user = null;
                    }
                    return this.user;
                }
            );
    }

    public newUser(user: User): Promise<User> {
        return this.http.post(this.usersUrl, JSON.stringify(user), { headers: this.headers })
            .toPromise()
            .then(res => {
                this.user = res.json().data as User;
                return this.user;
            })
            .catch(reason => this.handlePostError(reason));
    }

    public getUser(): User {
        return this.user;
    }

    public userClasses(id: number): Observable<Array<SchoolClass>> {
        return this.http.get(this.usersUrl + '?schoolclasses.id=' + id, {headers: this.headers})
            .map((res: Response) => res.json() as Array<SchoolClass>)
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    }

    private handlePostError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}