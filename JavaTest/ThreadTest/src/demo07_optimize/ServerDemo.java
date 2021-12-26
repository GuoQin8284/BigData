package demo07_optimize;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\a123131313.mp4"));
        byte[] bytes = new byte[1024];
        int b;
        while ((b = bis.read()) != -1){
            bos.write(b);
    }
        OutputStream outputStream = accept.getOutputStream();
        String res = "接收成功！";
        outputStream.write(res.getBytes());

        bos.close();
        accept.close();
        serverSocket.close();
    }
}