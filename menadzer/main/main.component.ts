import { CommonModule } from '@angular/common';
import { Component, computed, input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule, MatFormFieldModule, MatInputModule, MatSelectModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
   isSidebarCollapsed = input.required<boolean>();
    screenWidth = input.required<number>();
    sizeClass = computed(() => {
      const isSidebarCollapsed = this.isSidebarCollapsed();
      if (isSidebarCollapsed) {
        return '';
      }
      return this.screenWidth() > 768 ? 'body-trimmed' : 'body-md-screen';
    });
}
