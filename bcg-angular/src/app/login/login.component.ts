import { Component, OnInit } from '@angular/core';

import { ILogin } from '../ILogin';
import { Router } from '@angular/router';
import { LoginCommonServiceService } from '../login-common-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {

  }

  constructor(private route: Router, private login: LoginCommonServiceService) { }

  private empId: number;
  private password: string;

  private loginDto: ILogin = { empId: 0, password: '', roleId: 0, empName: '' };
  private errorMsg: string;


  /**
   * this method will be called when user clicks on login button 
   * and all the login details will be send to the login service
   */
  loginMethod() {
    this.loginDto = { empId: this.empId, password: this.password, roleId: 0, empName: '' };
    this.login.loginFunction(this.loginDto);
    this.errorMsg = this.login.getError();


  }

}



