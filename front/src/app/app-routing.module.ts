import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidatComponent } from './candidat/candidat.component';

const routes: Routes = [
  { path: 'candidat', component: CandidatComponent },
  {
      path: '**',
      redirectTo: 'candidat',     
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
