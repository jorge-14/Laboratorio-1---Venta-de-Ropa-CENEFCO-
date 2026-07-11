import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '', redirectTo: 'login', pathMatch: 'full'
  },
  {
    path: 'login', loadComponent: () => import('./pages/auth/login/login.component').then(m => m.LoginComponent)
  },
  {
    path: 'dashboard',
    loadComponent: () => import('./pages/dashboard/dashboard.component')
      .then(m => m.DashboardComponent),
    children: [
      {
        path: 'users',
        loadComponent: () => import('./pages/dashboard/user/user.component')
          .then(m => m.UserComponent)
      }
    ]
  },
  { path: '**', redirectTo: 'login' }
];
