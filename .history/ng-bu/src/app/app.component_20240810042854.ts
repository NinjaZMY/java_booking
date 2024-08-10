import { Component, HostListener, Input, ElementRef, ViewChild } from '@angular/core';
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

  c: any = undefined;
  log=console.log
  Cmd = {}
  Cmd.negate(o=modal)
  //eval: any = window.eval
  /*
  window.eval = eval

  eval = {window}.eval
  */
  // C = eval("this.c")

  title = 'angular-booking-app';
  position = { top: 0, left: 0 };
  isDragging = false;
  offsetX = 0;
  offsetY = 0;
  isModalOpen = false;
  falseModal = " this.isModalOpen = false;";

  @ViewChild('modal') modalElement!: ElementRef;

  /*   ngAfterViewInit() {
      if (this.isModalOpen) {
        this.centerModal();
      }
    } */

  openModal() {
    this.setInitialModalPosition();  // Calculate position before showing
    this.isModalOpen = true;
  }

  closeModal(C?: any) {
    if (arguments.length == 1) {
      C = confirm("do you really wanna close the modal ?")
      if (C)
        this.indirectEval(this.falseModal)
    }
    else
      this.indirectEval(this.falseModal)

    this.log(this.isModalOpen)

  }

  onButtonClick() {
    alert('Button clicked!');
  }

  // Prevent closing the modal when clicking inside it
  preventClose(event: MouseEvent) {
    event.stopPropagation();
  }



  startDragging(event: MouseEvent) {
    this.isDragging = true;
    this.offsetX = event.clientX - this.position.left;
    this.offsetY = event.clientY - this.position.top;
    event.preventDefault();
  }

  @HostListener('document:mousemove', ['$event'])
  onMouseMove(event: MouseEvent) {
    if (this.isDragging) {
      this.position.left = event.clientX - this.offsetX;
      this.position.top = event.clientY - this.offsetY;
    }
  }
  @HostListener('document:mouseup')
  onMouseUp() {
    this.isDragging = false;
  }

  // Listen for keydown events to detect "Esc" key
  @HostListener('document:keydown.escape', ['$event']) handleEscape(event: KeyboardEvent, c: any = this.c) {
    if (this.isModalOpen) {
      this.closeModal(c);
    }
  }

  setInitialModalPosition() {
    const modalWidth = 400; // Approximate width of the modal
    const modalHeight = 300; // Approximate height of the modal

    // Calculate centered position before showing the modal
    this.position.left = (window.innerWidth - modalWidth) / 2;
    this.position.top = (window.innerHeight - modalHeight) / 2;
  }


}
