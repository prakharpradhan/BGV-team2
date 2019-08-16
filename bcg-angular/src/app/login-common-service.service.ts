import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { ILogin } from './ILogin';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginCommonServiceService {
  private loginResult= []
  private errorMsg: string;
  constructor(private loginService: LoginService, private route: Router) { }

  /**
   * this method will check the login details from database
   * @param login 
   */
  loginFunction(login: ILogin) {

    this.loginService.login(login).subscribe(data => {
      {
        this.loginResult.push(data);
      } if (this.loginResult[0].roleId == 18018) {
        this.route.navigateByUrl("employee");
      }
      else if (this.loginResult[0].roleId== 54045) {
        this.route.navigateByUrl("bgv");
      }

    },
      error => {
        this.errorMsg = error.error.message;
      });;
  }
/**
 * getter Method for error
 */
  getError() {
    return this.errorMsg;
  }
/**
 * getter method for emp Id
 */
  getEmpId() {
    return this.loginResult[0].empId;
  }
  /**
   * getter  method for empName
   */
  getEmpName(){
    return this.loginResult[0].empName;
  }
}

