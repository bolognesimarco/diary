import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { UserService } from '../services/users.services';


import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
 
// Observable class extensions
import 'rxjs/add/observable/of';
 
// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

@Component({
    templateUrl: './login.html',
    styleUrls: ['./login.css']
})

export class Login {

    private username: string;
    private password: string;
    private message: string = null;

    constructor(
        private router: Router,
        private userService: UserService
    ){}


    onSubmit() {
        this.userService.login(
            this.username,
            this.password
        )
        .subscribe(
            user => {
                if ( user && user.role === 'headmaster' ) {
                    this.message = null;
                    this.router.navigate(['headmaster-home']);
                } else if ( user && user.role === 'teacher' ) {
                    this.message = null;
                    this.router.navigate(['teacher-home']);
                } else if ( user && user.role === 'scholar' ) {
                    this.message = null;
                    this.router.navigate(['scholar-home']);
                } else {
                    this.message = 'Wrong login!!';
                }
            },
            err => { console.log(err); }
        );
    }

}
