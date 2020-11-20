"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.AppRoutingModule = void 0;
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var courses_component_1 = require("./courses/courses.component");
var student_detail_component_1 = require("./student-detail/student-detail.component");
var student_form_component_1 = require("./student-form/student-form.component");
var students_component_1 = require("./students/students.component");
var routes = [
    { path: "courses", component: courses_component_1.CoursesComponent },
    { path: "students", component: students_component_1.StudentsComponent },
    { path: 'student-form', component: student_form_component_1.StudentFormComponent },
    { path: 'students/student-detail/:id', component: student_detail_component_1.StudentDetailComponent },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        core_1.NgModule({
            imports: [router_1.RouterModule.forRoot(routes)],
            exports: [router_1.RouterModule]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());
exports.AppRoutingModule = AppRoutingModule;
