import { Component, OnInit } from '@angular/core';
import { SchoolClass } from '../model/schoolclass.model';
import { SchoolClassesService } from '../services/schoolclasses.services';


@Component({
    selector: 'class-listttt',
    templateUrl: './class-list.html',
    styleUrls: ['./class-list.css']
})

export class ClassListComponent implements OnInit {

    private schoolClasses: Array<SchoolClass>;

    constructor(
        private schoolClassService: SchoolClassesService
    ) {}

    public ngOnInit(): void {
        this.schoolClassService.classesAll()
        .then(classes => {
            this.schoolClasses = classes;
        });

    }

}
