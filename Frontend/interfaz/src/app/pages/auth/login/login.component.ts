import {Component, OnInit, signal} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import {UserService} from '../../../core/service/user.service';

@Component({
  selector: 'login-component',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatProgressSpinnerModule

  ]
})

export class LoginComponent implements OnInit {

  name = "VIENER"

  loginForm: FormGroup;
  hidePassword = signal(true);
  isLoading = signal(false);
  errorMessage = signal('');

  constructor(private fb: FormBuilder,
              private router: Router,
              private userService: UserService) {



    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });



  }

  ngOnInit() {




  }

  onSubmit() {
    console.log("MI nombre es:", this.name)
    console.log("MI FORMULARIO ES ", this.loginForm.value)




    if (this.loginForm.invalid) return;

    this.isLoading.set(true);
    this.errorMessage.set('');

    const { email, password } = this.loginForm.value;

    this.userService.verifyCredentials(password, email).subscribe({
      next: (response: any) => {
        console.log("RESPONSE", response)
        this.isLoading.set(false);

        if (true) {
          this.router.navigate(['/dashboard']);
        } else {
          this.errorMessage.set('Correo o contraseña incorrectos');
        }
      },
      error: () => {
        this.isLoading.set(false);
        this.errorMessage.set('Error al conectar con el servidor');
      }
    });
  }

  getEmailError() {
    if (this.loginForm.get('email')?.hasError('required')) return 'El correo es obligatorio';
    if (this.loginForm.get('email')?.hasError('email')) return 'El correo no es válido';
    return '';
  }

  getPasswordError() {
    if (this.loginForm.get('password')?.hasError('required')) return 'La contraseña es obligatoria';
    if (this.loginForm.get('password')?.hasError('minlength')) return 'Mínimo 8 caracteres';
    return '';
  }
}







