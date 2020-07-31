import { Component, OnInit, NgModule, Input } from '@angular/core';
import { Transaction } from '../transaction';
import { Observable } from 'rxjs';
import { TransactionService } from '../transaction.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['../transaction-list/transaction-list.component.css']
})

export class SearchComponent implements OnInit {
  
  transactions: Observable<Transaction[]>;
  tRef: string;
  transaction: Transaction;
  btncontent:string = "Show Details";
  isClicked: boolean = false;

  constructor(private transactionService: TransactionService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {    
    this.tRef = this.route.snapshot.paramMap.get('transacRef');
    this.transactions = this.transactionService.searchTransactions(this.tRef);
  }
  
  screenAll() {
    //not working at all
    this.transactionService.getAllResultsScreened(this.tRef).subscribe((t) => this.transactions = t);    
    location.reload();   

    //not even this
    //this.transactions = this.transactionService.getAllResultsScreened(this.tRef);    
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

}
