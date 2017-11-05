import { Component } from '@angular/core';
import { User } from '../../model/user.model';
import { UserService } from '../../services/users.services';
import { SchoolClassesService } from '../../services/schoolclasses.services';


@Component({
    selector: 'headhome',
    templateUrl: './headhome.html',
    styleUrls: ['./headhome.css']
})

export class HeadHomeComponent {
    // private classes: boolean = true;
    // private subjects: boolean = false;
    private headmaster: User;

    constructor(
        private userService: UserService,
        private schoolClassesService: SchoolClassesService
    ) {
        this.headmaster = this.userService.getUser();
    }
}
