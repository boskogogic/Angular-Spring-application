import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-msidemenu',
  standalone: true,
  imports: [RouterModule, CommonModule, MatButtonModule ],
  templateUrl: './msidemenu.component.html',
  styleUrl: './msidemenu.component.css'
})
export class MsidemenuComponent {
    isSidebarCollapsed = input.required<boolean>();
    changeIsSidebarCollapsed = output<boolean>();
    constructor(private router : Router) {}

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
        routeLink: 'unoskvara',
        icon: 'fal fa-cog',
        label: 'Unos kvara',
      },
      {
        routeLink: 'unoscijene',
        icon: 'fal fa-cog',
        label: 'Unos cijene',
      },
      {
        routeLink: 'diagrami',
        icon: 'fal fa-cog',
        label: 'Diagrami',
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
  
