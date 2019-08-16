import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BgvComponent } from './bgv.component';


const routes: Routes = [
  {
    path:'',
    component:BgvComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BgvRoutingModule { }
