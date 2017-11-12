import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../model/user.model';
import { SchoolClass } from '../model/schoolclass.model';

@Component({
    selector: 'headmaster-class-detail',
    templateUrl: './headmaster-class-detail.html',
    styleUrls: ['./headmaster-class-detail.css']
})

export class HeadMasterClassDetail implements OnInit {

    @Input() schoolclass: SchoolClass;
    
    @Output() classDetailEvent = new EventEmitter();

    ngOnInit() {}

    public back(): void {
        this.classDetailEvent.emit();
    }
}
