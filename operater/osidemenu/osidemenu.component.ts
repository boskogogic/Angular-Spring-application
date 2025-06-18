import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-osidemenu',
  standalone: true,
  imports: [RouterModule, CommonModule, MatButtonModule ],
  templateUrl: './osidemenu.component.html',
  styleUrl: './osidemenu.component.css'
})
export class OsidemenuComponent {
    isSidebarCollapsed = input.required<boolean>();
    changeIsSidebarCollapsed = output<boolean>();
    items = [
      {
        routeLink: 'iznajmljivanja',
        icon: 'fal fa-home',
        label: 'Pregled iznajmljivanja',
      },
      {
        routeLink: 'prevoznasredstvanamapi',
        icon: 'fal fa-box-open',
        label: 'Prevozna sredstva na mapi',
      },
      {
        routeLink: 'korisnici',
        icon: 'fal fa-file',
        label: 'Pregled klijenata',
      },
      {
        routeLink: 'unoskvara',
        icon: 'fal fa-cog',
        label: 'Unos kvara',
      },
    ];

    constructor(private router : Router) {
      
    }
  
    toggleCollapse(): void {
      this.changeIsSidebarCollapsed.emit(!this.isSidebarCollapsed());
    }
  
    closeSidenav(): void {
      this.changeIsSidebarCollapsed.emit(true);
    }

    signOut() {
      this.router.navigate(['/login']);
    }
}
