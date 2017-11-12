import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../services/users.services';
import { SchoolClassesService } from '../services/schoolclasses.services';

import { User } from '../model/user.model';
import { SchoolClass } from '../model/schoolclass.model';


@Component({
    templateUrl: './headmaster-home.html',
    styleUrls: ['./headmaster-home.css']
})

export class HeadmasterHome implements OnInit {

    private headmaster: User;
    private schoolclass: SchoolClass;
    private classDetailView: boolean = false;

    constructor(
        private route: ActivatedRoute,
        private userService: UserService,
        private schoolClassesService: SchoolClassesService
    ) {
    }

    ngOnInit() {
        this.headmaster = this.userService.getUser();
    }

    public schoolClassDetail($event: any): void {
        this.schoolclass = $event.value;
        this.classDetailView = !this.classDetailView;
    }

    public back($event: any): void {
        this.classDetailView = !this.classDetailView;
    }

}
