import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagramiComponent } from './diagrami.component';

describe('DiagramiComponent', () => {
  let component: DiagramiComponent;
  let fixture: ComponentFixture<DiagramiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DiagramiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiagramiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
