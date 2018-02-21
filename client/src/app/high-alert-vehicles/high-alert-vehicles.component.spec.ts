import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HighAlertVehiclesComponent } from './high-alert-vehicles.component';

describe('HighAlertVehiclesComponent', () => {
  let component: HighAlertVehiclesComponent;
  let fixture: ComponentFixture<HighAlertVehiclesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HighAlertVehiclesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HighAlertVehiclesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
