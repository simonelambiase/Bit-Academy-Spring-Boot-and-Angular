import { Component, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field'
import { IStudente } from '../students/IStudente';
import { FormBuilder, FormGroup, NgForm, NgModel, Validators } from '@angular/forms';
import { Studente } from '../students/Studente';
import { StudentServiceService } from '../students/student-service.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {

  studentForm!: FormGroup;

  studente = new Studente();

  constructor( private service: StudentServiceService, private formBuilder: FormBuilder ) {

   }

  ngOnInit(): void {
    this.studentForm = this.formBuilder.group({
      fullName: ['', [Validators.required, Validators.pattern("% %")]],
      codiceFiscale: ['', [Validators.required, Validators.minLength(15)]],
      dataDiNascita: ['', [Validators.required]],
      indirizzo: ['', [Validators.required]],
      mail: ['', [Validators.required, Validators.email]],
      telefono: ['', [Validators.required, Validators.minLength(9)]],
      titoloDiStudio: ['', [Validators.required]],
      sesso: ['', [Validators.required]],
    });
  }

  onSubmit(studentForm: NgForm): void {
    this.service.addStudentToDB(this.studente).subscribe();
  }

  onSubmitReact(): void {
    this.service.addStudentToDB(this.studentForm.value).subscribe();
    // Aggiungere un back alla lista 
  }

}
