package jp.kwt.samples.chat.servlets;

import jp.kwt.samples.chat.handlers.Endpoint;
import jp.kwt.samples.chat.handlers.EndpointHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ChatServerServlet extends WebSocketServlet {
    private static final long serialVersionUID = 1L;

    public ChatServerServlet() {
        EndpointHandler.EndpointHandlerBuilder.buildEndpointHandler();
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(Endpoint.class);
    }
}
