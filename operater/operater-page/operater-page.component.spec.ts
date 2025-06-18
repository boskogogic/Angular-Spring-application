import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterPageComponent } from './operater-page.component';

describe('OperaterPageComponent', () => {
  let component: OperaterPageComponent;
  let fixture: ComponentFixture<OperaterPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OperaterPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperaterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
