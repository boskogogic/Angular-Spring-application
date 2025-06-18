import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoZaposleniComponent } from './info-zaposleni.component';

describe('InfoZaposleniComponent', () => {
  let component: InfoZaposleniComponent;
  let fixture: ComponentFixture<InfoZaposleniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoZaposleniComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoZaposleniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
