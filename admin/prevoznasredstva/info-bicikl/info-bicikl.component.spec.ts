import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBiciklComponent } from './info-bicikl.component';

describe('InfoBiciklComponent', () => {
  let component: InfoBiciklComponent;
  let fixture: ComponentFixture<InfoBiciklComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoBiciklComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBiciklComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
