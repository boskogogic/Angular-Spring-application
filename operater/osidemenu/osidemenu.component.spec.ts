import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OsidemenuComponent } from './osidemenu.component';

describe('OsidemenuComponent', () => {
  let component: OsidemenuComponent;
  let fixture: ComponentFixture<OsidemenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OsidemenuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OsidemenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
