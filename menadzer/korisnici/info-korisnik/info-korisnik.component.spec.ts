import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoKorisnikComponent } from './info-korisnik.component';

describe('InfoKorisnikComponent', () => {
  let component: InfoKorisnikComponent;
  let fixture: ComponentFixture<InfoKorisnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoKorisnikComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
