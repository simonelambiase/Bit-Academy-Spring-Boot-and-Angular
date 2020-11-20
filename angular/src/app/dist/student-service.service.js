"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.StudentServiceService = void 0;
var core_1 = require("@angular/core");
var rxjs_1 = require("rxjs");
var operators_1 = require("rxjs/operators");
var StudentServiceService = /** @class */ (function () {
    function StudentServiceService(client) {
        this.client = client;
    }
    StudentServiceService.prototype.getAllStudents = function () {
        return this.client.get("http://localhost:8080/api/studente")
            .pipe(operators_1.tap(function (data) { return console.log('All: ' + JSON.stringify(data)); }), operators_1.catchError(this.handleError));
    };
    StudentServiceService.prototype.handleError = function (err) {
        var errorMessage = '';
        if (err.error instanceof ErrorEvent) {
            errorMessage = "An error occurred: " + err.error.message;
        }
        else {
            errorMessage = "Server returned code: " + err.status + ", error message is: " + err.message;
        }
        console.error(errorMessage);
        return rxjs_1.throwError(errorMessage);
    };
    StudentServiceService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], StudentServiceService);
    return StudentServiceService;
}());
exports.StudentServiceService = StudentServiceService;
