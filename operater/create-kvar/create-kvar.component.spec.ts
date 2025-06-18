import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateKvarComponent } from './create-kvar.component';

describe('CreateKvarComponent', () => {
  let component: CreateKvarComponent;
  let fixture: ComponentFixture<CreateKvarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateKvarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateKvarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
