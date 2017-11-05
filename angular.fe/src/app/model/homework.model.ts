import { XDate } from '../util/xdate';
import { Subject } from './subject.model';

export class Homework {
    id: number;
    subject: Subject;
    description: string;
    done: boolean; // for students
    checked: boolean; // for teachers
    assignmenDate: XDate; // when the homework was assigned, from teachers or auto assigned
    minDueDate: XDate; // not before date, after this date on first occurence of subject
}