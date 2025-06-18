import { Component, HostListener, signal } from '@angular/core';
import { OsidemenuComponent } from '../osidemenu/osidemenu.component';
import { MainComponent } from '../main/main.component';

@Component({
  selector: 'app-operater-page',
  standalone: true,
  imports: [OsidemenuComponent, MainComponent],
  templateUrl: './operater-page.component.html',
  styleUrl: './operater-page.component.css'
})
export class OperaterPageComponent {
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
