import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import { Router } from '@angular/router';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})

export class UploadComponent implements OnInit {

  @ViewChild('fileInput') fileInput: ElementRef;
 
  uploader: FileUploader;
  isDropOver: boolean;

  ngOnInit(): void {
    const headers = [{name: 'Accept', value: 'application/json'}];
    this.uploader = new FileUploader({url: 'http://localhost:8080/springboot-crud-rest/upload', autoUpload: true, headers: headers});
 
    this.uploader.onCompleteAll = () => {      
      alert('File uploaded');      
      window.location.href = "uploaded";
    }
  }
 
  fileOverAnother(e: any): void {
    this.isDropOver = e;
  }
 
  fileClicked() {
    this.fileInput.nativeElement.click();
  }


}
  