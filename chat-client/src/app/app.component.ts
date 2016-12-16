import { Component } from '@angular/core';
import {WebSocketService} from "./ws.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [WebSocketService]
})
export class AppComponent {
  constructor(private webSocketService: WebSocketService) {
    const connection = webSocketService.connect("ws://localhost:10080/ws");
    connection.subscribe((res) => {
      console.log(res);
    });
  }
  title = 'app works!';
}
