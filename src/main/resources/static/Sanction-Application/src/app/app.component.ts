import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Sanction-Application';
  transacRef:string;
  filterValue:string = '';
  
  constructor(router: Router){}

  clear(){
    this.transacRef = null;
  }

  selectChangeHandler(event:any){
    this.filterValue = event.target.value;
  }
}