import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProizvodjaciComponent } from './proizvodjaci.component';

describe('ProizvodjaciComponent', () => {
  let component: ProizvodjaciComponent;
  let fixture: ComponentFixture<ProizvodjaciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProizvodjaciComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProizvodjaciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
