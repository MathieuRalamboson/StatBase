import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CandidatComponent } from './candidat/candidat.component';
import { CandidatService } from './service/candidat.service';

@NgModule({
  declarations: [
    AppComponent,
    CandidatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [CandidatService],
  bootstrap: [AppComponent]
})
export class AppModule { }
