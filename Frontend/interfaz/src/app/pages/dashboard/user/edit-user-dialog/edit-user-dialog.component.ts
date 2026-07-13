import { Component, Inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import {UserService} from '../../../../core/service/user.service';

@Component({
  selector: 'app-edit-user-dialog',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatSnackBarModule
  ],
  templateUrl: './edit-user-dialog.component.html',
  styleUrl: './edit-user-dialog.component.scss'
})
export class EditUserDialogComponent {

  form: FormGroup;
  isLoading = signal(false);

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private fb: FormBuilder,
              private userService: UserService,
              private snackbar: MatSnackBar,
              private dialogRef: MatDialogRef<EditUserDialogComponent>) {
    console.log("INFORMACION,", this.data)
    this.form = this.fb.group({
      name: [data.name, Validators.required],
      surnamePaternal: [data.surnamePaternal, Validators.required],
      surnameMaternal: [data.surnameMaternal, Validators.required],
      ci: [data.ci, Validators.required],
      email: [data.email, [Validators.required, Validators.email]],
      username: [data.username, Validators.required],
      password: [data.password, [Validators.required, Validators.minLength(8)]],
    })
  }

  ngOnInit() {
  }

  onSubmit(){
    if (this.form.invalid) return;
    this.isLoading.set(true);

    this.userService.updateUser(this.data.id, this.form.value).subscribe({
      next: ()=> {
        this.isLoading.set(false);
        this.snackbar.open('Usuario actualizado exitosamente', 'cerrar', {duration: 3000})
        this.dialogRef.close(true)

      }
    })
  }

}
