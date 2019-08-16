import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { BgvComponent } from './bgv/bgv.component';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { DatePipe } from '@angular/common';
import { ViewStatusComponent } from './employee/view-status/view-status.component';



@NgModule({
  declarations: [
    AppComponent,
   EmployeeComponent,BgvComponent,LoginComponent,ViewStatusComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, HttpClientModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
