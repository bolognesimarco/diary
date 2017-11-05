export class XDate {
    constructor(
        private year: number,
        private month: number,
        private day: number
    ){}
    

    public asDate(): Date {
        return new Date(this.year, this.month-1, this.day);
    }
}