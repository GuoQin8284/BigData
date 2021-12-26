package demo18_httpServer.myServlet;

import demo18_httpServer.HttpServlet.HttpRequest;
import demo18_httpServer.HttpServlet.HttpResponse;

public class RegisterServlet implements HttpServlet{
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.println("servlet处理了注册请求");
        httpResponse.setContent("text/html;Charset=UTF-8");
        httpResponse.write("注册成功");
    }
}
