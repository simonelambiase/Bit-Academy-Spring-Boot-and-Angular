import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, NgModel, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IStudente } from '../students/IStudente';
import { StudentServiceService } from '../students/student-service.service';
import { Location } from '@angular/common'

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  studente!: IStudente;

  constructor(private service: StudentServiceService, private route: ActivatedRoute, private location: Location ) {

  }

  ngOnInit(): void {
    this.service.getStudentById(this.route.snapshot.params.id).subscribe((student) => {
      this.studente = student;
    });
  }

  onSubmit(signupForm: NgForm): void {
    this.service.updateStudent(this.studente).subscribe();
    alert(`Hai aggiornato lo studente ${this.studente.fullName}. Ritorno alla lista...`);
    this.location.back();
  }

  onDelete() {
    this.service.deleteStudente(this.route.snapshot.params.id).subscribe(); 
    alert(`Hai eliminato lo studente ${this.studente.fullName}. Ritorno alla lista...`);
    this.location.back();
    
  }
  
  confirmDelete() {
    if (confirm('Sei sicuro di voler eliminare questo studente?')) {
      this.onDelete();
    }
  }
    

}