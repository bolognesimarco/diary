"use strict";
var XDate = (function () {
    function XDate(year, month, day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    XDate.prototype.asDate = function () {
        return new Date(this.year, this.month - 1, this.day);
    };
    return XDate;
}());
exports.XDate = XDate;
//# sourceMappingURL=xdate.js.map