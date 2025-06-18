import { Component, HostListener, signal } from '@angular/core';
import { MsidemenuComponent } from '../msidemenu/msidemenu.component';
import { MainComponent } from '../main/main.component';

@Component({
  selector: 'app-menadzer',
  standalone: true,
  imports: [MsidemenuComponent, MainComponent],
  templateUrl: './menadzer.component.html',
  styleUrl: './menadzer.component.css'
})
export class MenadzerComponent {
   isSidebarCollapsed = signal<boolean>(false);
    screenWidth = signal<number>(window.innerWidth);
  
    changeIsSidebarCollapsed(isSidebarCollapsed: boolean): void {
      this.isSidebarCollapsed.set(isSidebarCollapsed);
    }
  
    @HostListener('window:resize')
    onResize() {
      this.screenWidth.set(window.innerWidth);
      if (this.screenWidth() < 768) {
        this.isSidebarCollapsed.set(true);
      }
    }
}
