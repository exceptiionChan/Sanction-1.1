import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css'],
})
export class TransactionListComponent implements OnInit {

  transactions: Observable<Transaction[]>;
  transaction: Transaction;
  btncontent:string = "Show Details";
  isClicked: boolean = false;
  @Input() status:string;

  constructor(private transactionService: TransactionService,
    private router: Router) { }  
  
  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.transactions = this.transactionService.getTransactionsList();
  }

  screenAll() {
    this.transactions = this.transactionService.getAllScreened();
  }

  toggleButtonContent(){
    this.isClicked = !this.isClicked;
    if(this.isClicked)
      this.btncontent ="Close Details"    
    else
      this.btncontent ="Show Details"   
  }

  screenTransaction(id: number) {
    this.transactionService.getScreenedTransaction(id)
      .subscribe((t) => this.transaction = t);
      location.reload();
  }

  filter(){
    this.transactionService.getFiltered(status)
    .subscribe((t) => this.transactions = t);
    location.reload();
  }

}
