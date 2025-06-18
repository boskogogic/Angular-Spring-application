import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoAutomobilComponent } from './info-automobil.component';

describe('InfoAutomobilComponent', () => {
  let component: InfoAutomobilComponent;
  let fixture: ComponentFixture<InfoAutomobilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoAutomobilComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoAutomobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
