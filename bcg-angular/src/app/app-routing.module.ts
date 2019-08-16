import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BgvComponent } from './bgv/bgv.component';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { ViewStatusComponent } from './employee/view-status/view-status.component';


const routes: Routes = [
  {
    path: 'employee',
    component: EmployeeComponent
  }, {
    path: '', pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'bgv',
    component: BgvComponent
  }, {
    path: 'employee/view',
    component: ViewStatusComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
