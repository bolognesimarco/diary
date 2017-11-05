export class Schedule {
    id: number;
    dayOfWeek: number;//getday javascript like 0-6, 0 sunday
    subjects: Array<number>;//ordered list of subjects
}