import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../model/user.model';
import { SchoolClass } from '../model/schoolclass.model';

@Component({
    selector: 'headmaster-class-list',
    templateUrl: './headmaster-class-list.html',
    styleUrls: ['./headmaster-class-list.css']
})

export class HeadMasterClassList implements OnInit {

    @Output() classDetailEvent = new EventEmitter();

    @Input() headmaster: User;

    ngOnInit() {}

    public classDetail(schoolclass: SchoolClass): void {
        this.classDetailEvent.emit({value: schoolclass});
    }
    
}