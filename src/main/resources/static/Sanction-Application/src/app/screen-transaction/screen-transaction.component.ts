import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-screen-transaction',
  templateUrl: './screen-transaction.component.html',
  styleUrls: ['./screen-transaction.component.css']
})
export class ScreenTransactionComponent implements OnInit {

  transactions: Observable<Transaction[]>;
  btncontent:string = "Show Details";
  isClicked: boolean = false;

  constructor(private transactionService: TransactionService,
    private router: Router) { }

  transaction: Transaction;

  ngOnInit() {
    this.screenAll();
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

}
