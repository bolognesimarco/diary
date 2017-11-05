import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../model/user.model';
import { SchoolClass } from '../../model/schoolclass.model';
import { UserService } from '../../services/users.services';

@Component({
    selector: 'headclasses-list',
    templateUrl: './headclasses.html',
    styleUrls: ['./headclasses.css']
})

export class HeadClassesComponent implements OnInit {

    @Input() headmaster: User;
    private classes: Array<SchoolClass>;

    constructor(
        private route: ActivatedRoute,
        private usersServices: UserService
    ){
    }

    public ngOnInit(): void {
        this.usersServices.userClasses(this.headmaster.id).subscribe(
            returnedClasses => { 
                this.classes = returnedClasses;
            },
            err => { console.log(err); }
        );
    }
}