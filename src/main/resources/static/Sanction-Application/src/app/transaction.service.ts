import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest';

  constructor(private http: HttpClient) { }

  getTransactionsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/transactions`);
  }
  
  getAllScreened(): Observable<any> {
    return this.http.get(`${this.baseUrl}/screen`);
  }

  // getTransaction(id: number): Observable<any> {
  //   return this.http.get(`${this.baseUrl}/${id}`);
  // }

}
