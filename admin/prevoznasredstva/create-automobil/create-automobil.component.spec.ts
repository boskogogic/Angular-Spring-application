import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAutomobilComponent } from './create-automobil.component';

describe('CreateAutomobilComponent', () => {
  let component: CreateAutomobilComponent;
  let fixture: ComponentFixture<CreateAutomobilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateAutomobilComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAutomobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
