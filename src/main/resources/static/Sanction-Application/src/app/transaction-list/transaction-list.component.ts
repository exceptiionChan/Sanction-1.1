import { Observable } from "rxjs";
import { TransactionService } from "../transaction.service";
import { Transaction } from "../transaction";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  transactions: Observable<Transaction[]>;
  btncontent:string = "Show Details";
  isClicked: boolean = false;

  constructor(private transactionService: TransactionService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.transactions = this.transactionService.getTransactionsList();
  }
  
  toggleButtonContent(){
    this.isClicked = !this.isClicked;
    if(this.isClicked)
      this.btncontent ="Close Details"    
    else
      this.btncontent ="Show Details"   
  }
  
  // route() {
  //   this.router.navigate(['/details', this.transaction]);
  // } 

}
