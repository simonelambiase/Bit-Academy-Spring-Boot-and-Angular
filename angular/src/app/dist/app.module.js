"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.AppModule = void 0;
var platform_browser_1 = require("@angular/platform-browser");
var core_1 = require("@angular/core");
var http_1 = require("@angular/common/http");
var app_routing_module_1 = require("./app-routing.module");
var app_component_1 = require("./app.component");
var animations_1 = require("@angular/platform-browser/animations");
var button_1 = require("@angular/material/button");
var table_1 = require("@angular/material/table");
var courses_component_1 = require("./courses/courses.component");
var students_component_1 = require("./students/students.component");
var ng_bootstrap_1 = require("@ng-bootstrap/ng-bootstrap");
var paginator_1 = require("@angular/material/paginator");
var student_form_component_1 = require("./student-form/student-form.component");
var form_field_1 = require("@angular/material/form-field");
var core_2 = require("@angular/material/core");
var select_1 = require("@angular/material/select");
var forms_1 = require("@angular/forms");
var is_full_name_valid_directive_1 = require("./student-form/is-full-name-valid.directive");
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                courses_component_1.CoursesComponent,
                students_component_1.StudentsComponent,
                student_form_component_1.StudentFormComponent,
                is_full_name_valid_directive_1.IsFullNameValidDirective
            ],
            imports: [
                platform_browser_1.BrowserModule,
                app_routing_module_1.AppRoutingModule,
                http_1.HttpClientModule,
                animations_1.BrowserAnimationsModule,
                button_1.MatButtonModule,
                table_1.MatTableModule,
                paginator_1.MatPaginatorModule,
                form_field_1.MatFormFieldModule,
                core_2.MatOptionModule,
                select_1.MatSelectModule,
                forms_1.FormsModule,
                forms_1.ReactiveFormsModule,
                ng_bootstrap_1.NgbModule,
            ],
            providers: [],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
