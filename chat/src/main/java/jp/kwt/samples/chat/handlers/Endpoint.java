package jp.kwt.samples.chat.handlers;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebSocket
public class Endpoint {
    private Session session_;
    private final static Logger logger = LoggerFactory.getLogger(Endpoint.class);

    public Session getSession() {
        return session_;
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        logger.debug("onConnect : " + session.getRemoteAddress());
        this.session_ = session;
        EndpointHandler handler = EndpointHandler.getInstance();
        handler.register(this);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws IOException {
        logger.debug("onMessage : " + message);
        EndpointHandler handler = EndpointHandler.getInstance();
        handler.broadcastMessage(message);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        EndpointHandler handler = EndpointHandler.getInstance();
        handler.removeByInstance(this);
    }

    @OnWebSocketError
    public void onError(Throwable cause) {
        EndpointHandler handler = EndpointHandler.getInstance();
        handler.removeByInstance(this);
        cause.printStackTrace(System.err);
    }
}