import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CredentialDto } from '../model/CredentialDto';
import { Student } from '../model/Student';

@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {
  urlBase:string="http://localhost:8000/crud";
  token:string;
  user:string="admin";
  pwd:string="admin";
  constructor( private http:HttpClient) {
    this.getToken();
  }
  getToken(){
    let dto:CredentialDto =new CredentialDto();
    dto.pwd=this.pwd;
    dto.user=this.user;
    this.http.post(this.urlBase+"/login",dto,{responseType:"text"}).subscribe(tk=>this.token=tk);

  }

  getStudentId(idAlumno:number){
    //con append y set no funciona
    let heads:HttpHeaders=new HttpHeaders({"Authorization":"Bearer "+this.token});
    return this.http.get<Student>(this.urlBase+"/Alumno/"+idAlumno,{headers:heads});
  }
  getStudents(){
    let heads:HttpHeaders=new HttpHeaders({"Authorization":"Bearer "+this.token});
    return this.http.get<Student[]>(this.urlBase+"/Alumnos",{headers:heads});

  }

}
