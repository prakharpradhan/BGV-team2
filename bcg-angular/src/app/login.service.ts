import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ILogin } from './ILogin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  /**
   * this method takes login object and send it to the spring boot's tomcat server
   * @param login 
   */
  login(login:ILogin){
   
    var url_total = 'http://3.92.213.155:8080/login';
    return this.http.post(url_total, login);
  

}
}
