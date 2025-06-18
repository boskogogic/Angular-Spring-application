import { Component,  HostListener,  signal } from '@angular/core';
import { SidemenuComponent } from '../sidemenu/sidemenu.component';
import { AppComponent } from '../../app.component';
import { MainComponent } from '../main/main.component';

@Component({
  selector: 'app-admin-page',
  imports: [SidemenuComponent, MainComponent],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
 
})
export class AdminPageComponent {
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
