import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidemenu',
  standalone: true,
  imports: [RouterModule, CommonModule, MatButtonModule ],
  templateUrl: './sidemenu.component.html',
  styleUrl: './sidemenu.component.css'
})
export class SidemenuComponent {
    isSidebarCollapsed = input.required<boolean>();
    changeIsSidebarCollapsed = output<boolean>();
    constructor(private router : Router) {
      
    }

    items = [
      {
        routeLink: 'prevoznasredstva',
        icon: 'fal fa-home',
        label: 'Prevozna sredstva',
      },
      {
        routeLink: 'proizvodjaci',
        icon: 'fal fa-file',
        label: 'Proizvodjaci',
      },
      {
        routeLink: 'korisnici',
        icon: 'fal fa-cog',
        label: 'Korisnici',
      },
    ];
  
    toggleCollapse(): void {
      this.changeIsSidebarCollapsed.emit(!this.isSidebarCollapsed());
    }
  
    closeSidenav(): void {
      this.changeIsSidebarCollapsed.emit(true);
    }

    signOut() : void {
      this.router.navigate(['/login']);
    }
}
  
