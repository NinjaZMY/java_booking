import { Component, HostListener } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'angular-booking-app';

  isModalOpen = false;

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }

  onButtonClick() {
    alert('Button clicked!');
  }

  // Prevent closing the modal when clicking inside it
  preventClose(event: MouseEvent) {
    event.stopPropagation();
  }

  // Listen for keydown events to detect "Esc" key
  @HostListener('document:keydown.escape', ['$event']) handleEscape(event: KeyboardEvent) {
    if (this.isModalOpen) {
      this.closeModal();
    }
  }

}
