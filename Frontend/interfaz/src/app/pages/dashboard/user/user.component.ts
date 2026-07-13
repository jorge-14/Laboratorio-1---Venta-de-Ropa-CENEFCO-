import {Component, OnInit, signal} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { CreateUserDialogComponent } from './create-user-dialog/create-user-dialog.component';
import {UserService} from '../../../core/service/user.service';
import {EditUserDialogComponent} from './edit-user-dialog/edit-user-dialog.component';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-users',
  standalone: true,
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatSnackBarModule,
  ]
})

export class UserComponent implements OnInit {

  users = signal<any[]>([]);
  isLoading = signal(false);
  displayedColumns = ['name', 'ciUser', 'userEmail', 'actions']

  constructor(private dialog : MatDialog,
              private snackbar: MatSnackBar,
              private userService: UserService) {




  }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.isLoading.set(true);
    this.userService.listUsers().subscribe({
      next: (response) => {
        this.users.set(response.data);
        this.isLoading.set(false);
      }
    })
  }

  openCreateDialog() {
    const dialogRef = this.dialog.open(CreateUserDialogComponent, {
      width: '500px'
    })
  }

  openEditDialog(user: any){
    const dialogRef = this.dialog.open(EditUserDialogComponent, {
      width: '500px',
      data: user
    })
  }

  deleteUser(user: any) {
    console.log("Eliminar");

    this.userService.deleteUser(user.id).subscribe({
      next: () => {
        this.snackbar.open('Usuario Eliminado', 'cerrar', {duration: 3000})
        this.loadUsers();
      }
    })

  }
}


