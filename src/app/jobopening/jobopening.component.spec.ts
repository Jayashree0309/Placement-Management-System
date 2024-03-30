import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobopeningComponent } from './jobopening.component';

describe('JobopeningComponent', () => {
  let component: JobopeningComponent;
  let fixture: ComponentFixture<JobopeningComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JobopeningComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobopeningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
