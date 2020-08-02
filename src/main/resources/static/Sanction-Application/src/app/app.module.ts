import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransactionListComponent } from './transaction-list/transaction-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SearchComponent } from './search/search.component';
import { FormsModule } from '@angular/forms';
import { FileUploadModule } from 'ng2-file-upload';
import { UploadComponent } from './upload/upload.component';
import { UploadedFileComponent } from './uploaded-file/uploaded-file.component';
import { FilteredTransactionsComponent } from './filtered-transactions/filtered-transactions.component';
//import { InfiniteScrollModule } from 'ngx-infinite-scroll';

@NgModule({
  declarations: [
    AppComponent,
    TransactionListComponent,
    SearchComponent,
    UploadComponent,
    UploadedFileComponent,
    FilteredTransactionsComponent,  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    FileUploadModule,    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
