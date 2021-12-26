package demo18_httpServer.myServlet;

import demo18_httpServer.HttpServlet.HttpRequest;
import demo18_httpServer.HttpServlet.HttpResponse;

public class UserServlet implements HttpServlet {
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.println("UserServlet处理了请求");
    }
}
