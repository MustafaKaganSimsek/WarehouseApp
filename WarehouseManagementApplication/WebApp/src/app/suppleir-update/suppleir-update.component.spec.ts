import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuppleirUpdateComponent } from './suppleir-update.component';

describe('SuppleirUpdateComponent', () => {
  let component: SuppleirUpdateComponent;
  let fixture: ComponentFixture<SuppleirUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuppleirUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuppleirUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
