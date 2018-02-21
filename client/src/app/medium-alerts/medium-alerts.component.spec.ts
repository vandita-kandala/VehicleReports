import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MediumAlertsComponent } from './medium-alerts.component';

describe('MediumAlertsComponent', () => {
  let component: MediumAlertsComponent;
  let fixture: ComponentFixture<MediumAlertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MediumAlertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MediumAlertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
