import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry, tap } from 'rxjs/operators';
import { IStudente } from './IStudente';
import { Studente } from './Studente';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  constructor(private client: HttpClient) {


  }


  getAllStudents(): Observable<IStudente[]> {
    return this.client.get<IStudente[]>("http://localhost:8080/api/studente")
      .pipe(
        tap(data => console.log('All: ' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }

  getStudentById( id: Number ): Observable<IStudente> {
    return this.client.get<IStudente>(`http://localhost:8080/api/studente/${id}`)
    .pipe(
      tap(data => console.log('All: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  addStudentToDB (student: Studente): Observable<Studente> {
    return this.client.post("http://localhost:8080/api/studente", student)
      .pipe(
        catchError(this.handleError)
      );
  }

  updateStudent(student: IStudente) : Observable<Studente> {
    return this.client.put<IStudente>(`http://localhost:8080/api/studente/id/${student.id}`, student)
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteStudente(id: Number): Observable<Studente> {
    return this.client.delete(`http://localhost:8080/api/studente/id/${id}`)
    .pipe(
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