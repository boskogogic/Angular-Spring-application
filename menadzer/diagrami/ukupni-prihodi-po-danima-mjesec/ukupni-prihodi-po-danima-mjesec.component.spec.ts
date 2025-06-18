import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UkupniPrihodiPoDanimaMjesecComponent } from './ukupni-prihodi-po-danima-mjesec.component';

describe('UkupniPrihodiPoDanimaMjesecComponent', () => {
  let component: UkupniPrihodiPoDanimaMjesecComponent;
  let fixture: ComponentFixture<UkupniPrihodiPoDanimaMjesecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UkupniPrihodiPoDanimaMjesecComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UkupniPrihodiPoDanimaMjesecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
