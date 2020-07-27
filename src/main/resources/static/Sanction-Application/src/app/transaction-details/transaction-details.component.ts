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
  
  constructor( private transactionService: TransactionService, private route: ActivatedRoute, private router: Router) { }

  data = this.route.params.subscribe(data => {
    console.log(data); 
  })
  
  ngOnInit(){    
  }

  list(){
    this.router.navigate(['/transactions']);
  }
  
}
