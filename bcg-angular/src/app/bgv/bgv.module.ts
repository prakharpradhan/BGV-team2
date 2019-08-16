import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BgvRoutingModule } from './bgv-routing.module';
import { BgvComponent } from './bgv.component';


@NgModule({
  declarations: [BgvComponent],
  imports: [
    CommonModule,
    BgvRoutingModule
  ]
})
export class BgvModule { }
