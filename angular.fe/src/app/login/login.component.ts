import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { UserService } from '../services/users.services';

@Component({
    templateUrl: './login.html',
    styleUrls: ['./login.css']
})

export class LoginComponent {
    model = new User();

    constructor(
        private router: Router,
        private userService: UserService
    ){}


    onSubmit() {
        this.userService.login(this.model.username, this.model.password).subscribe(
            user => {
                this.model = user;
                if ( this.model.role === 'headmaster' ) {
                    this.router.navigate(['headhome']);
                }
            },
            err => { console.log(err); }
        );
    }

}
