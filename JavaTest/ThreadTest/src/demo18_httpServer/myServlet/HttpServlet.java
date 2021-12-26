package demo18_httpServer.myServlet;

import demo18_httpServer.HttpServlet.HttpRequest;
import demo18_httpServer.HttpServlet.HttpResponse;

public interface HttpServlet {
    public abstract void service(HttpRequest httpRequest, HttpResponse httpResponse);
}
