package demo18_httpServer.HttpServlet;

import demo18_httpServer.myServlet.LoginServlet;
import demo18_httpServer.myServlet.RegisterServlet;
import demo18_httpServer.myServlet.UserServlet;

public class DynamicResponseProcess {
    public void process(HttpRequest httpRequest, HttpResponse httpResponse){
        if ("/servlet/login".equals(httpRequest.getUri())){
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.service(httpRequest,httpResponse);
        }else if("/servlet/register".equals(httpRequest.getUri())){
            RegisterServlet registerServlet = new RegisterServlet();
            registerServlet.service(httpRequest,httpResponse);
        }else if ("/servlet/userservlet".equals(httpRequest.getUri())){
            UserServlet userServlet = new UserServlet();
            userServlet.service(httpRequest,httpResponse);
        }
        httpResponse.write("OK,uservervlet处理了本次请求");
    }
}
