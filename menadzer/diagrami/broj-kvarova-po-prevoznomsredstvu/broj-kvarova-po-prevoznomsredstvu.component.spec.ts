import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrojKvarovaPoPrevoznomsredstvuComponent } from './broj-kvarova-po-prevoznomsredstvu.component';

describe('BrojKvarovaPoPrevoznomsredstvuComponent', () => {
  let component: BrojKvarovaPoPrevoznomsredstvuComponent;
  let fixture: ComponentFixture<BrojKvarovaPoPrevoznomsredstvuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BrojKvarovaPoPrevoznomsredstvuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BrojKvarovaPoPrevoznomsredstvuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
