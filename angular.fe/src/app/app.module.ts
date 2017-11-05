import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { HttpModule, JsonpModule } from '@angular/http';
import { EqualValidator } from './shared/equal-validator.directive';

import '../assets/css/styles.css';
import '../assets/css/forms.css';


// import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
// import { InMemoryDataService }  from './in-memory-data.service';

import { AppComponent } from './app.component';

import { Login } from './pages/login';
import { HeadmasterHome } from './pages/headmaster-home';
import { TeacherHome } from './pages/teacher-home';
import { ScholarHome } from './pages/scholar-home';
import { HeadMasterClassList } from './tags/headmaster-class-list';
import { HeadMasterClassDetail } from './tags/headmaster-class-detail';

import { LoginComponent } from './login/login.component';
import { HeadHomeComponent } from './headmaster/headhome/headhome.component';
import { HeadClassesComponent } from './headmaster/headclasses/headclasses.component';
import { RegistrationComponent } from './registration/registration.component';
import { ClassListComponent } from './class-list/class-lis.component';


import { appRoutes } from './app.routes';
import { RouterModule, Routes } from '@angular/router';

import { UserService } from './services/users.services';
import { SchoolClassesService } from './services/schoolclasses.services';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule, JsonpModule,
    // InMemoryWebApiModule.forRoot(InMemoryDataService),
    RouterModule.forRoot(appRoutes)
  ],
  declarations: [
    AppComponent, Login, HeadmasterHome, TeacherHome, ScholarHome, HeadMasterClassList, HeadMasterClassDetail,
    LoginComponent, HeadHomeComponent, HeadClassesComponent, RegistrationComponent, EqualValidator, ClassListComponent
  ],
  bootstrap: [ AppComponent ],
  providers: [ UserService, SchoolClassesService ]
})
export class AppModule { }
