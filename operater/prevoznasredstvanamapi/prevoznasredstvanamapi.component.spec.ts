import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevoznasredstvanamapiComponent } from './prevoznasredstvanamapi.component';

describe('PrevoznasredstvanamapiComponent', () => {
  let component: PrevoznasredstvanamapiComponent;
  let fixture: ComponentFixture<PrevoznasredstvanamapiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PrevoznasredstvanamapiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrevoznasredstvanamapiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
