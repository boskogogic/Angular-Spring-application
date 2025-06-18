import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProizvodjacComponent } from './update-proizvodjac.component';

describe('UpdateProizvodjacComponent', () => {
  let component: UpdateProizvodjacComponent;
  let fixture: ComponentFixture<UpdateProizvodjacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateProizvodjacComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateProizvodjacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
