import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnosCijeneComponent } from './unos-cijene.component';

describe('UnosCijeneComponent', () => {
  let component: UnosCijeneComponent;
  let fixture: ComponentFixture<UnosCijeneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UnosCijeneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnosCijeneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
