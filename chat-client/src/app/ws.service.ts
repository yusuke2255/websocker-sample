import * as Rx from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class WebSocketService {
  private socket: Rx.Subject<MessageEvent>;
  public connect(url): Rx.Subject<MessageEvent> {
    if(!this.socket) {
      this.socket = this.create(url);
    }
    return this.socket;
  }

  private create(url): Rx.Subject<MessageEvent> {
    let ws = new WebSocket(url);
    ws.
    let observable = Rx.Observable.create(
      (obs: Rx.Observer<MessageEvent>) => {
        ws.onmessage = obs.next.bind(obs);
        ws.onerror = obs.error.bind(obs);
        ws.onclose = obs.complete.bind(obs);
        return ws.close.bind(ws);
      }
    );
    let observer = {
      next: (data: Object) => {
        console.log("-----------");
        console.log(data);
        if (ws.readyState === WebSocket.OPEN) {
          ws.send(JSON.stringify(data));
        }
      },
    };
    return Rx.Subject.create(observer, observable);
  }
}
