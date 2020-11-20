import { Component, OnInit } from '@angular/core';
import { CoursesService } from './courses.service';
import { ICourse } from './ICourse';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: ICourse[] = [];
  errorMessage: string = "";
  columnsToDisplay = ['nomeCorso', 'materiaCorso','categoriaCorso','maxIscritti','dataInizio','durataCorso','aulaPreferita'];
  
  constructor(private service: CoursesService) { }

  ngOnInit(): void {
    this.service.getAllCourses().subscribe({
      next: courses => {
        this.courses = courses;
      }, error: err => this.errorMessage = err
    });
  }
}

