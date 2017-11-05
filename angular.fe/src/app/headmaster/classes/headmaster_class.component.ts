import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
    templateUrl: './headmaster_class.html',
    styleUrls: ['./headmaster_class.css']
})

export class HeadmasterClassComponent implements OnInit {

    constructor(
        private route: ActivatedRoute
    ){}

    public ngOnInit(): void {
    }
}
