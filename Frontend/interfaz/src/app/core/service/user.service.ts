import {Injectable, signal} from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class UserService {

  private apiUrl = 'http://localhost:8080/api/v1/user';

  isLoading = signal(false);
  hasError = signal(false);
  errorMessage = signal('');

  constructor(private http: HttpClient) {}

  verifyCredentials( password: string,email: string) {
    this.isLoading.set(true);
    this.hasError.set(false);
    this.errorMessage.set('');
    return this.http.put<any>(`${this.apiUrl}/verification-user/${password}/${email}`, {});
  }

  createUser(data: any) {
    return this.http.post<any>(`${this.apiUrl}/create-user`, data);
  }

  listUsers() {
    this.isLoading.set(true);
    return this.http.get<any>(`${this.apiUrl}/list-information-user`);
  }

  updateUser(id: number, data: any) {
    return this.http.put<any>(`${this.apiUrl}/update-user/${id}`, data);
  }

  deleteUser(id: number) {
    return this.http.put<any>(`${this.apiUrl}/delete-user/${id}`, {});
  }
}





