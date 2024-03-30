import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Job } from './job.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private httpClient:HttpClient) { }

  apiURL="http://localhost:8080/jobopening"

  createJobOpening(jb:Job):Observable<Job>
  {
    return this.httpClient.post<Job>(this.apiURL,jb);
  }

  getJobOpening():Observable<Job[]>
  {
    return this.httpClient.get<Job[]>(this.apiURL);
  }

  updateJobOpening(jobId:number,jb:Job):Observable<Job>
  {
    return this.httpClient.put<Job>(this.apiURL+'/'+jobId,jb);
  }
  deleteJobOpening(jobId:number)
  {
    return this.httpClient.delete(this.apiURL+'/'+jobId);
  }
}
