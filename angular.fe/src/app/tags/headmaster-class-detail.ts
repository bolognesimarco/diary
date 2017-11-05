import { Component, OnInit, Input } from '@angular/core';
import { User } from '../model/user.model';
import { SchoolClass } from '../model/schoolclass.model';

@Component({
    selector: 'headmaster-class-detail',
    templateUrl: './headmaster-class-detail.html',
    styleUrls: ['./headmaster-class-detail.css']
})

export class HeadMasterClassDetail implements OnInit {

    @Input() schoolclass: SchoolClass;

    ngOnInit() {}
}
