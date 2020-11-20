import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { IStudente } from '../students/IStudente';
import { ICourse } from './ICourse';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  constructor(private client: HttpClient) {


  }

  getAllCourses(): Observable<ICourse[]> {
    return this.client.get<ICourse[]>("http://localhost:8080/api/corso")
      .pipe(
        tap(data => console.log('All: ' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  
}
