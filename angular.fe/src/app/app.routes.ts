import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import  { Login } from './pages/login';

import { RegistrationComponent } from './registration/registration.component';
import { HeadmasterHome } from './pages/headmaster-home';
import { TeacherHome } from './pages/teacher-home';
import { ScholarHome } from './pages/scholar-home';

export const appRoutes: Routes = [

    {
        path: 'login',
        component: Login
    },
    {
        path: 'headmaster-home',
        component: HeadmasterHome
    },
    {
        path: 'teacher-home',
        component: TeacherHome
    },
    {
        path: 'scholar-home',
        component: ScholarHome
    },
    {
        path: 'registration',
        component: RegistrationComponent
    },
    {
        path: '',
        component: Login
    },
    // otherwise redirect to home
    { path: '**', redirectTo: 'login' }
];
