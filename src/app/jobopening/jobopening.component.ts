import { Component, OnInit } from '@angular/core';
import { Job } from './job.model';
import { JobService } from './job.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-jobopening',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './jobopening.component.html',
  styleUrl: './jobopening.component.css'
})
export class JobopeningComponent implements OnInit {

  constructor(private jobservice: JobService) { }

  ngOnInit(): void {
    this.getJobOpening();
  }


  newJob: Job = { companyId: NaN, title: "", description: "", postingDate: new Date(""), deadline: new Date("") };

  jobList: Job[] = [];
  editingJob: Job | null = null;
  updateJobOpening: Job = {companyId: NaN, title: "", description: "", postingDate: new Date(""), deadline: new Date("") };

  createJobOpening() {
    this.jobservice.createJobOpening(this.newJob).subscribe(result => {
      this.jobList.push(result);  
    })
    this.newJob = { companyId: NaN, title: "", description: "", postingDate: new Date(""), deadline: new Date("") };
  }

  getJobOpening() {
    this.jobservice.getJobOpening().subscribe(result => {
      this.jobList = result;
    })
  }

  editJobOpening(editJobOpening: Job) {
    this.editingJob = editJobOpening;
    this.updateJobOpening ={...editJobOpening} ;
  }

  updateJobOpeningByid() {
    this.jobservice.updateJobOpening(this.editingJob!.jobId!, this.updateJobOpening).subscribe(result => {
      const index = this.jobList.findIndex((job) => job.jobId == this.editingJob!.jobId);

      if (index !== -1) {
        this.jobList[index] = result;
      }
    });
    this.updateJobOpening = {companyId: NaN, title: "", description: "", postingDate: new Date(""), deadline: new Date("") };
  }

  deleteJobOpeningById() {
    this.jobservice.deleteJobOpening(this.editingJob!.jobId!).subscribe(() => {
    this.getJobOpening();
    });
  }


}
