import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevoznasredstvaComponent } from './prevoznasredstva.component';

describe('PrevoznasredstvaComponent', () => {
  let component: PrevoznasredstvaComponent;
  let fixture: ComponentFixture<PrevoznasredstvaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PrevoznasredstvaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrevoznasredstvaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
