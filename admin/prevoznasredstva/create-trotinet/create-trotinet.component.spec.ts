import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTrotinetComponent } from './create-trotinet.component';

describe('CreateTrotinetComponent', () => {
  let component: CreateTrotinetComponent;
  let fixture: ComponentFixture<CreateTrotinetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateTrotinetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateTrotinetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
