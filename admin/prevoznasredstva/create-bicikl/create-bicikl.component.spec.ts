import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBiciklComponent } from './create-bicikl.component';

describe('CreateBiciklComponent', () => {
  let component: CreateBiciklComponent;
  let fixture: ComponentFixture<CreateBiciklComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateBiciklComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateBiciklComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
