import { Schedule } from './schedule.model';
import { Subject } from './subject.model';

export class SchoolClass {
    id: number;
    name: string;
    weekDaySchedules: Array<Schedule>; // every week day is a schedule
    subjects: Array<Subject>; // subjects of this class
}
