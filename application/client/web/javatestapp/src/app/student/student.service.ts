import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
    providedIn: 'root'
})

export class StudentService {
    constructor(
        private http: HttpClient,
    ) { }


  BaseURL = environment.WEB_API;


  PostAllstudentValues(data:any){
    return this.http.post(`${this.BaseURL}/student`,data);
  }

  GetAllstudentValues(){
    return this.http.get(`${this.BaseURL}/student`);
  }

  Updatestudent(data:any){
    return this.http.put(`${this.BaseURL}/student/${data.id}`,data);
  }

  getSpecificstudent(id:number){
    return this.http.get(`${this.BaseURL}/student/${id}`);
  }

  getSpecificstudentHistory(id:number){
    return this.http.get(`${this.BaseURL}/student/${id}/history?days=30`);
  }

  DeletestudentValues(dataId:any){
     return this.http.delete(`${this.BaseURL}/student/${dataId}`);
  }

  GetEntityById(studentId:any): Observable<any> {
    return this.http.get(`${this.BaseURL}/studentid/` + studentId);
  }

  Searchstudent(data:any): Observable<any> {
    const temp:any = [];
    const objectKeyPair = Object.entries(data);
    objectKeyPair.forEach((element, index) => {
    if (element[1]) {
    temp.push(`${element[0]}=${element[1]}`);
    }
    });
    let jwt_token = sessionStorage.getItem('JwtToken');
    return this.http.get(`${this.BaseURL}` + `/student/get/search?jwt_token=${jwt_token}${temp.length > 0 ? `&${temp.join('&')}` : ''}`);
  }
}