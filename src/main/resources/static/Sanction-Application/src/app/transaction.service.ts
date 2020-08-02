import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest';
  sharedResult: Observable<Transaction[]>;

  constructor(private http: HttpClient) { }

  getTransactionsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/transactions`);
  }
  
  getAllScreened(): Observable<any> {
    return this.http.get(`${this.baseUrl}/screen`);
  }

  getScreenedTransaction(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/screen/${id}`);
  }

  searchTransactions(transacRef: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/search/${transacRef}`);
  }

  //
  getAllResultsScreened(transacRef: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/search/screen/${transacRef}`);
  }

  getFiltered(status: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/filter/${status}`);
  }

  getFileTransactions(): Observable<any>{
    return this.http.get(`${this.baseUrl}/uploaded`);
  }

  getFileFiltered(status: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/uploaded/filter/${status}`);
  }

  getAllFileScreened(): Observable<any> {
    return this.http.get(`${this.baseUrl}/uploaded/screen`);
  }

}
