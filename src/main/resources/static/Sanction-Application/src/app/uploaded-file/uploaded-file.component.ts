import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { Observable } from 'rxjs';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-uploaded-file',
  templateUrl: './uploaded-file.component.html',
  styleUrls: ['./uploaded-file.component.css']
})
export class UploadedFileComponent implements OnInit {

  transactions: Observable<Transaction[]>;
  transaction: Transaction;
  btncontent:string = "Show Details";
  isClicked: boolean = false; 

  constructor(private transactionService: TransactionService) { }  
  
  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.transactions = this.transactionService.getFileTransactions();
  }

  //
  screenAll() {
    this.transactions = this.transactionService.getAllFileScreened();
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

  //
  filter(){
    this.transactionService.getFileFiltered(status)
    .subscribe((t) => this.transactions = t);
    location.reload();
  }
}
