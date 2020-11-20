import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IscrizioneDetailsComponent } from './iscrizione-details.component';

describe('IscrizioneDetailsComponent', () => {
  let component: IscrizioneDetailsComponent;
  let fixture: ComponentFixture<IscrizioneDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IscrizioneDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IscrizioneDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
