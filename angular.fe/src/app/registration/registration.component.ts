import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { UserService } from '../services/users.services';

@Component({
    selector: 'registration-form',
    templateUrl: './registration.html',
    styleUrls: ['./registration.css']
})

export class RegistrationComponent {
    roles = ['Headmaster', 'Teacher', 'Student'];
    model = new User();
    submitted = false;
    repassword = '';

    constructor(
        private router: Router,
        private userService: UserService
    ){}

    onSubmit() {
        this.submitted = true;
        this.userService.newUser(this.model)
            .then(user => {
                this.model = user;
                console.log('new ID: ' + this.model.id);
                if (user.role === 'Headmaster') {
                    this.router.navigate(['/headmasters/', user.id]);
                }
            });
    }

    get diagnostic() { return JSON.stringify(this.model); }
}
