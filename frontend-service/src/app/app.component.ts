import {Component, OnInit} from '@angular/core';
import {State, StateService} from '../generated/restClient';
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'indian-maharaja-tours-frontend';
  states:State[] = [];
  constructor(private StateService: StateService ) {
  }

  private getAllStates() {
    this.StateService.getAllStates().toPromise()
        .then(
            data => {
              this.states = data;
            },
            (e: HttpErrorResponse) => {
              console.log('HttpErrorResponse :: ' + e.message);
            }
        );
  }

  ngOnInit(): void {
    this.getAllStates();
  }
}
