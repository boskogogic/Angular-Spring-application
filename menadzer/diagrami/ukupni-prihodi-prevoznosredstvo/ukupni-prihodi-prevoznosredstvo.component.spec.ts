import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UkupniPrihodiPrevoznosredstvoComponent } from './ukupni-prihodi-prevoznosredstvo.component';

describe('UkupniPrihodiPrevoznosredstvoComponent', () => {
  let component: UkupniPrihodiPrevoznosredstvoComponent;
  let fixture: ComponentFixture<UkupniPrihodiPrevoznosredstvoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UkupniPrihodiPrevoznosredstvoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UkupniPrihodiPrevoznosredstvoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
