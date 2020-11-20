import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { IStudente } from './IStudente';
import { StudentServiceService } from './student-service.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})

export class StudentsComponent implements OnInit, AfterViewInit {

  studenti: IStudente[] = [];
  columnsToDisplay = ['id', 'fullName', 'codiceFiscale', 'dataDiNascita', 'indirizzo', 'mail', 'telefono', 'titoloDiStudio'];
  dataSource = new MatTableDataSource<IStudente>(this.studenti);
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private service: StudentServiceService) {
  }


  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {

    this.service.getAllStudents().subscribe({
      next: studenti => {
        this.studenti = studenti;
      }
    });

  }
  
}