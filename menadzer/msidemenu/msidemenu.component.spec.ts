import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsidemenuComponent } from './msidemenu.component';

describe('MsidemenuComponent', () => {
  let component: MsidemenuComponent;
  let fixture: ComponentFixture<MsidemenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MsidemenuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MsidemenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
