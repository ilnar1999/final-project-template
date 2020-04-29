$(document).ready(function() {
    getCurrentDate();
});

function getCurrentDate() {
    let date = new Date;
    let month = date.getMonth() + 1;
    let day = date.getDate();
    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    let dateAsString = date.getFullYear() + "-" + month + "-" + day;
    document.getElementById("date-of-birthday").setAttribute("max", dateAsString);
}