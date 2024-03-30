import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { JobopeningComponent } from './jobopening/jobopening.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,JobopeningComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'project';
}
