import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { TransactionListComponent } from './transaction-list/transaction-list.component';
import { SearchComponent } from './search/search.component';
import { UploadComponent } from './upload/upload.component';


//npm uninstall @ng-bootstrap/ng-bootstrap

const routes: Routes = [
  {path:"",redirectTo:"transactions", pathMatch: "full"},
  { path: 'transactions', component: TransactionListComponent },
  { path: 'search/:transacRef', component: SearchComponent },
  { path: 'upload', component: UploadComponent },
  // {path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules, // or NoPreloading
  })
],
  exports: [RouterModule]
})
export class AppRoutingModule { }
