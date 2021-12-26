package demo08_tcp_while;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        UUID uuid = UUID.randomUUID();
        while (true){
            Socket accept = serverSocket.accept();
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\"+ uuid.toString() +".mp4"));
            byte[] bytes = new byte[1024];
            int b;
            while ((b = bis.read(bytes)) != -1){
                bos.write(bytes,0,b);
            }
            OutputStream outputStream = accept.getOutputStream();
            String res = "接收成功！";
            outputStream.write(res.getBytes());
            bos.close();
            accept.close();
        }
    }
}