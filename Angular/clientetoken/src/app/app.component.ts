import { Component } from '@angular/core';
import { Student } from './model/Student';
import { TokenServiceService } from './service/token-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'clientetoken';
  alumno:Student
  idAlumno:number

  constructor(private service: TokenServiceService){}

  buscarAlumno(){
    this.service.getStudentId(this.idAlumno).subscribe(s=>this.alumno = s)
    
  }
}
