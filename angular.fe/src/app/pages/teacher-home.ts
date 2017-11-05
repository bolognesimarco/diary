import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { UserService } from '../services/users.services';

import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';

import { User } from '../model/user.model';
 
// Observable class extensions
import 'rxjs/add/observable/of';
 
// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import 'rxjs/add/operator/switchMap';

@Component({
    templateUrl: './teacher-home.html',
    styleUrls: ['./teacher-home.css']
})

export class TeacherHome implements OnInit {

    private teacher: User;

    constructor(
        private route: ActivatedRoute,
        private userService: UserService
    ) {
    }

    ngOnInit() {
        this.teacher = this.userService.getUser();
    }

}
