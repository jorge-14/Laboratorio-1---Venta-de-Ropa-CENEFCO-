import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatSidenavModule,
    MatListModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  menuItems = [
    { icon: 'dashboard', label: 'Inicio', route: '/dashboard' },
    { icon: 'people', label: 'Usuarios', route: '/dashboard/users' },
    { icon: 'checkroom', label: 'Productos', route: '/dashboard/products' },
    { icon: 'shopping_cart', label: 'Ventas', route: '/dashboard/sales' },
    { icon: 'category', label: 'Categorías', route: '/dashboard/categories' },
  ];

  stats = [
    { icon: 'people', label: 'Usuarios', value: '128', color: '#1976d2' },
    { icon: 'checkroom', label: 'Productos', value: '340', color: '#388e3c' },
    { icon: 'shopping_cart', label: 'Ventas', value: '85', color: '#f57c00' },
    { icon: 'attach_money', label: 'Ingresos', value: 'Bs. 12,400', color: '#7b1fa2' },
  ];

  constructor(private router: Router) {}

  logout() {
    this.router.navigate(['/login']);
  }
}
