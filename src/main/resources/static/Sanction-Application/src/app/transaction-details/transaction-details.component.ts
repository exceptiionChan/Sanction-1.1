import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-transaction-details',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent implements OnInit {  
  
  transaction: Transaction;

  constructor( private transactionService: TransactionService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(){  
    let id = this.route.snapshot.paramMap.get("id");
    //this.transaction = this.transactionService.getTransaction(id);
  }

  // list(){
  //   this.router.navigate(['/transactions']);
  // }
  
}
