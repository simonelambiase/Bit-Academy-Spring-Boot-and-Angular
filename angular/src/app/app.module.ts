import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button'; 
import { MatTableModule } from '@angular/material/table';
import { CoursesComponent } from './courses/courses.component';
import { StudentsComponent } from './students/students.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'; 
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { StudentFormComponent } from './student-form/student-form.component';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IsFullNameValidDirective } from './student-form/is-full-name-valid.directive';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { IscrizioneDetailsComponent } from './iscrizione-details/iscrizione-details.component';



@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    StudentsComponent,
    StudentFormComponent,
    IsFullNameValidDirective,
    StudentDetailComponent,
    IscrizioneDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
