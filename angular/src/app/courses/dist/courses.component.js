"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.CoursesComponent = void 0;
var core_1 = require("@angular/core");
var CoursesComponent = /** @class */ (function () {
    function CoursesComponent(service) {
        this.service = service;
        this.courses = [];
        this.errorMessage = "";
        this.columnsToDisplay = ['nomeCorso', 'materiaCorso', 'categoriaCorso', 'maxIscritti', 'dataInizio', 'durataCorso', 'aulaPreferita'];
    }
    CoursesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getAllCourses().subscribe({
            next: function (courses) {
                _this.courses = courses;
            }, error: function (err) { return _this.errorMessage = err; }
        });
    };
    CoursesComponent = __decorate([
        core_1.Component({
            selector: 'app-courses',
            templateUrl: './courses.component.html',
            styleUrls: ['./courses.component.css']
        })
    ], CoursesComponent);
    return CoursesComponent;
}());
exports.CoursesComponent = CoursesComponent;
