import { Component } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Sanction-Application';
  transacRef:string;
  status:string = '';
  
  constructor(router: Router, private route:ActivatedRoute){}

  clear(){
    this.transacRef = null;
  }

  selectChangeHandler(event:any){
    this.status = event.target.value;
  }
}