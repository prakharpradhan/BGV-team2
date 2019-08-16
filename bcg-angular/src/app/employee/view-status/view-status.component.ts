import { Component, OnInit } from '@angular/core';
import { ViewStatusService } from 'src/app/view-status.service';
import { LoginCommonServiceService } from 'src/app/login-common-service.service';

@Component({
  selector: 'app-view-status',
  templateUrl: './view-status.component.html',
  styleUrls: ['./view-status.component.css']
})
export class ViewStatusComponent implements OnInit {

  empId: any = this.login.getEmpId();
  empName: any = this.login.getEmpName();
  docType: string;
  constructor(private viewService: ViewStatusService, private login: LoginCommonServiceService) { }
  statusDetails = [];
  ngOnInit() {
    /**
     * view status of request
     */
    this.viewService.viewDocStatus(this.login.getEmpId())
      .subscribe(resp => {
        
        this.statusDetails.push(resp)
      });
  }
}
