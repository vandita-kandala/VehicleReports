import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LowAlertsComponent } from './low-alerts.component';

describe('LowAlertsComponent', () => {
  let component: LowAlertsComponent;
  let fixture: ComponentFixture<LowAlertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LowAlertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LowAlertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
