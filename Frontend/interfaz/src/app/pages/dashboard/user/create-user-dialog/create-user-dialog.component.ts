import {Component, OnInit, signal} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import {UserService} from '../../../../core/service/user.service';

@Component({
  selector: 'app-create-user-dialog',
  standalone: true,
  templateUrl: './create-user-dialog.component.html',
  styleUrl : './create-user-dialog.component.scss',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatSnackBarModule
  ]
})

export class CreateUserDialogComponent implements OnInit {

  form: FormGroup;
  isLoading = signal(false);

  constructor(private fb: FormBuilder,
              private userService: UserService,
              private snackbar: MatSnackBar,
              private dialogRef: MatDialogRef<CreateUserDialogComponent>) {
    this.form = this.fb.group({
      name: ['', Validators.required],
      surnamePaternal: ['', Validators.required],
      surnameMaternal: ['', Validators.required],
      ci: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
    })
  }

  ngOnInit() {
  }

  onSubmit(){
    if (this.form.invalid) return;
    this.isLoading.set(true);

    this.userService.createUser(this.form.value).subscribe({
      next: () => {
        this.snackbar.open('Usuario creado exitosamente', 'cerrar', {duration: 3000})
        this.dialogRef.close(true)
      }
    })
  }
}
