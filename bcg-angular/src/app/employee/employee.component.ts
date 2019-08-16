import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { LoginCommonServiceService } from '../login-common-service.service';
import { DatePipe } from '@angular/common';
import { DocumentUploadService } from '../document-upload.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  errorflag: boolean = false;
  successflag: boolean = false;
  flag: boolean = true;
  selectedFile: File = null;
  uploadMessage = [];
  check: Boolean = false;
  uploadDate: any = new Date();
  opened: boolean = false;
  showMessage: boolean = false;

  constructor(private datePipe: DatePipe, private login: LoginCommonServiceService, private _documentUploadService: DocumentUploadService) {
    this.uploadDate = this.datePipe.transform(this.uploadDate, 'yyyy-MM-dd');
  }
  private documentType: number;
  private empId: any;
  private empName: any;
  private documentDetails: any = { empId: 0, docTypeId: 0, verificationDTO: { requestStartDate: null, requestEndDate: null, status: "" } };
  private errorMsg: string;

  ngOnInit() {

    this.empName = this.login.getEmpName();

  }


  onFileSelected(event) {

    this.selectedFile = <File>event.target.files[0];
    this.flag = false;

  }
  /**
   * upload document
   */
  onUpload() {
    this.errorflag = false;
    if (this.documentType == 1) {
      this.documentDetails.docTypeId = 51012;
    }
    else {
      this.documentDetails.docTypeId = 42012;
    }
    this.documentDetails.empId = this.login.getEmpId();
    this.documentDetails.verificationDTO.requestStartDate = this.uploadDate;
    this.documentDetails.verificationDTO.requestEndDate = null;
    this.documentDetails.verificationDTO.status = "pending";

    this._documentUploadService.uploadDocument(this.selectedFile).subscribe(data => {

      this.check = true;
      this.uploadMessage.push(data);

      this.flag = true;
    }, error => {
      this.errorflag = true;
      this.errorMsg = error.error.message;
    });



    this._documentUploadService.uploadFile(this.documentDetails).subscribe(data => {

      this.errorflag = false;
      this.check = true;
      this.uploadMessage.push(data);


    }, error => {
      this.errorflag = true;
      this.errorMsg = error.error.message;
    });

  }

}
