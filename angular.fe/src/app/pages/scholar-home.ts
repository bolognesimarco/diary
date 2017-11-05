import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { UserService } from '../services/users.services';

import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';

import { User } from '../model/user.model';

@Component({
    templateUrl: './scholar-home.html',
    styleUrls: ['./scholar-home.css']
})

export class ScholarHome implements OnInit {

    private scholar: User;

    constructor(
        private route: ActivatedRoute,
        private userService: UserService
    ) {
    }

    ngOnInit() {
        this.scholar = this.userService.getUser();
    }

}
