import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransactionListComponent } from './transaction-list/transaction-list.component';
import {ScreenTransactionComponent} from './screen-transaction/screen-transaction.component'

const routes: Routes = [
  {path:"",redirectTo:"transactions", pathMatch: "full"},
  { path: 'transactions', component: TransactionListComponent },
  { path: 'screen', component: ScreenTransactionComponent },
  // {path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
