package demo18_httpServer.myServlet;

import demo18_httpServer.HttpServlet.HttpRequest;
import demo18_httpServer.HttpServlet.HttpResponse;

public class LoginServlet implements HttpServlet{

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.println("servlet处理了登录请求");
        httpResponse.setContent("text/html;Charset=UTF-8");
        httpResponse.write("登录成功");
    }
}
