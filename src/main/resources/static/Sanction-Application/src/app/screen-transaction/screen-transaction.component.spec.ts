import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScreenTransactionComponent } from './screen-transaction.component';

describe('ScreenTransactionComponent', () => {
  let component: ScreenTransactionComponent;
  let fixture: ComponentFixture<ScreenTransactionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScreenTransactionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScreenTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
