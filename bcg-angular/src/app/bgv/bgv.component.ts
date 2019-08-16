import { Component, OnInit } from '@angular/core';

import { LoginCommonServiceService } from '../login-common-service.service';
import { BgTeamService } from '../bg-team.service';

@Component({
  selector: 'app-bgv',
  templateUrl: './bgv.component.html',
  styleUrls: ['./bgv.component.css']
})
export class BgvComponent implements OnInit {
  name: string;
  id: number;
  empName: any;
  searchParameter: number = 1;
  employeeName: any = [];
  employeeId: any;
  errorMsg: string;
  documentIds = [];
  documentId: number;
  documentTypeIds = [];
  documentTypeId: number;
  loopCounter = 0;
  showTable: boolean = false;
  showError: boolean = false;
  buttondisable: boolean = true;
  showSuccessMsg: boolean = false;


  constructor(private bgService: BgTeamService, private login: LoginCommonServiceService) { }
  private loginId: any;
  ngOnInit() {
    this.empName = this.login.getEmpName();
  }
  /**
   * search emp on its id and name
   */
  search() {
    this.documentTypeIds = [];
    this.documentIds = [];

    if (this.searchParameter == 1) {

      this.bgService.searchEmp(this.searchParameter, null, this.id)
        .subscribe(resp => {
          this.buttondisable = false;
          this.showTable = true;
          for (this.loopCounter = 0; this.loopCounter < resp.length; this.loopCounter++) {
            this.documentIds.push(resp[this.loopCounter].docId);
            this.documentTypeIds.push(resp[this.loopCounter].docTypeId)
          }



        }, error => {
          this.buttondisable = true;
          this.showError = true;
          this.errorMsg = error.error.message;
          this.showTable = false
        });
    }
    else {
      this.bgService.searchEmp(this.searchParameter, this.name, 0)
        .subscribe(resp => {
          this.buttondisable = false;
          this.showTable = true;
          for (this.loopCounter = 0; this.loopCounter < resp.length; this.loopCounter++) {
            this.documentIds.push(resp[this.loopCounter].docId);
            this.documentTypeIds.push(resp[this.loopCounter].docTypeId)
          }



        }, error => {
          this.buttondisable = true;
          this.showError = true;
          this.errorMsg = error.error.message;
          this.showTable = false
        });
    }

  }

  onChange() {
    if (this.documentTypeId == 42012) {
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(42012)];
    }
    else {
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(51012)];
    }
  }
  /**
   * approve request status
   */
  approve() {
    this.showError = false;
    this.showSuccessMsg = false;
    if (this.documentTypeId == 42012) {
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(42012)];
      this.bgService.approveDocument(this.documentId)
        .subscribe(resp =>
          this.showSuccessMsg = true,
          error => {
            this.errorMsg = error.error.message
            this.showError = true;
          });
    }
    else {
      this.showError = false;
      this.showSuccessMsg = false;
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(51012)];
      this.bgService.approveDocument(this.documentId)
        .subscribe(resp =>
          this.showSuccessMsg = true,
          error => {
            this.errorMsg = error.error.message
            this.showError = true;
          });
    }

  }
  /**
   * reject request status
   */

  reject() {
    this.showError = false;
    this.showSuccessMsg = false;
    if (this.documentTypeId == 42012) {
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(42012)];
      this.bgService.rejectDocument(this.documentId)
        .subscribe(resp => this.showSuccessMsg = true,
          error => {
            this.errorMsg = error.error.message;
            this.showError = true;
          });
    }
    else {
      this.showError = false;
      this.showSuccessMsg = false;
      this.documentId = this.documentIds[this.documentTypeIds.indexOf(51012)];
      this.bgService.rejectDocument(this.documentId)
        .subscribe(resp => this.showSuccessMsg = true,
          error => {

            this.errorMsg = error.error.message;
            alert(this.errorMsg);
            this.showError = true;
          });
    }

  }
}
