"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.StudentDetailComponent = void 0;
var core_1 = require("@angular/core");
var StudentDetailComponent = /** @class */ (function () {
    function StudentDetailComponent(service, route, location) {
        this.service = service;
        this.route = route;
        this.location = location;
    }
    StudentDetailComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getStudentById(this.route.snapshot.params.id).subscribe(function (student) {
            _this.studente = student;
        });
    };
    StudentDetailComponent.prototype.onSubmit = function (signupForm) {
        this.service.updateStudent(this.studente).subscribe();
        alert("Hai aggiornato lo studente " + this.studente.fullName + ". Ritorno alla lista...");
        this.location.back();
    };
    StudentDetailComponent.prototype.onDelete = function () {
        this.service.deleteStudente(this.route.snapshot.params.id).subscribe();
        alert("Hai eliminato lo studente " + this.studente.fullName + ". Ritorno alla lista...");
        this.location.back();
    };
    StudentDetailComponent.prototype.confirmDelete = function () {
        if (confirm('Sei sicuro di voler eliminare questo studente?')) {
            this.onDelete();
        }
    };
    StudentDetailComponent = __decorate([
        core_1.Component({
            selector: 'app-student-detail',
            templateUrl: './student-detail.component.html',
            styleUrls: ['./student-detail.component.css']
        })
    ], StudentDetailComponent);
    return StudentDetailComponent;
}());
exports.StudentDetailComponent = StudentDetailComponent;
