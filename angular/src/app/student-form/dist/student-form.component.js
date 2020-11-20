"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.StudentFormComponent = void 0;
var core_1 = require("@angular/core");
var forms_1 = require("@angular/forms");
var Studente_1 = require("../students/Studente");
var StudentFormComponent = /** @class */ (function () {
    function StudentFormComponent(service, formBuilder) {
        this.service = service;
        this.formBuilder = formBuilder;
        this.studente = new Studente_1.Studente();
    }
    StudentFormComponent.prototype.ngOnInit = function () {
        this.studentForm = this.formBuilder.group({
            fullName: ['', [forms_1.Validators.required, forms_1.Validators.pattern("% %")]],
            codiceFiscale: ['', [forms_1.Validators.required, forms_1.Validators.minLength(15)]],
            dataDiNascita: ['', [forms_1.Validators.required]],
            indirizzo: ['', [forms_1.Validators.required]],
            mail: ['', [forms_1.Validators.required, forms_1.Validators.email]],
            telefono: ['', [forms_1.Validators.required, forms_1.Validators.minLength(9)]],
            titoloDiStudio: ['', [forms_1.Validators.required]],
            sesso: ['', [forms_1.Validators.required]]
        });
    };
    StudentFormComponent.prototype.onSubmit = function (studentForm) {
        this.service.addStudentToDB(this.studente).subscribe();
    };
    StudentFormComponent.prototype.onSubmitReact = function () {
        this.service.addStudentToDB(this.studentForm.value).subscribe();
        // Aggiungere un back alla lista 
    };
    StudentFormComponent = __decorate([
        core_1.Component({
            selector: 'app-student-form',
            templateUrl: './student-form.component.html',
            styleUrls: ['./student-form.component.css']
        })
    ], StudentFormComponent);
    return StudentFormComponent;
}());
exports.StudentFormComponent = StudentFormComponent;
