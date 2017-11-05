import { SchoolClass } from './schoolclass.model';
import { Homework } from './homework.model';

export class User {
    id: number;
    username: string;
    password: string;
    name: string;
    surname: string;
    email: string;
    role: string;
    homeworks: Array<Homework>; // if role==teacher, homework assigned; else if role==student, homework to do
    classes: Array<SchoolClass>; // if role==headmaster, schoolclasses managed, if role==teacher, schoolclasses assigned; else if role==student, schoolclasses subscribed
}
