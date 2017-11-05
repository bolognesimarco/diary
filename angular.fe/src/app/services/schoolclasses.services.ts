import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { SchoolClass } from '../model/schoolclass.model';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { User } from '../model/user.model';

@Injectable()
export class SchoolClassesService {

    private headers = new Headers({ 'Content-Type': 'application/json' });
    private classesUrl: string = 'api/classes/';
    private userClassesUrl: string = 'api/userclasses/';

    constructor(private http: Http) { }


    public userClasses(id: number): Observable<SchoolClass[]> {
        return this.http
            .get(
                this.userClassesUrl + '/' + id,
                {headers: this.headers}
            )
            .map(
                res => {
                    console.log(res.json().data);
                    return res.json().data[0].schoolclasses as SchoolClass[];
                }
            );
    }


    public class(id: number): Observable<SchoolClass> {
        return this.http.get(this.classesUrl + '?id=' + id, {headers: this.headers})
            .map((res: Response) => res.json() as SchoolClass)
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    }

    public classesAll(): Promise<Array<SchoolClass>> {
        return this.http.get(this.classesUrl, { headers: this.headers })
            .toPromise()
            .then(res => {
                return res.json().data as Array<SchoolClass>;
            })
            .catch(reason => this.handlePostError(reason));
    }

    private handlePostError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}