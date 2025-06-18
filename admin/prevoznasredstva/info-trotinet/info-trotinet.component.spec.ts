import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoTrotinetComponent } from './info-trotinet.component';

describe('InfoTrotinetComponent', () => {
  let component: InfoTrotinetComponent;
  let fixture: ComponentFixture<InfoTrotinetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoTrotinetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoTrotinetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
