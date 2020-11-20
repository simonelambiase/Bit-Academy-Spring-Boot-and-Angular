import { Component, OnInit } from '@angular/core';
import { pipe } from 'rxjs';

import { IStudente } from './students/IStudente';
import { StudentServiceService } from './students/student-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
    title: string = "Accademia";
  

}
