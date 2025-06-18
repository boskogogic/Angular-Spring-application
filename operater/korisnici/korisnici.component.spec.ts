import { ComponentFixture, TestBed } from '@angular/core/testing';
import { KorisniciOperaterComponent } from './korisnici.component';


describe('KorisniciComponent', () => {
  let component: KorisniciOperaterComponent;
  let fixture: ComponentFixture<KorisniciOperaterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [KorisniciOperaterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KorisniciOperaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
