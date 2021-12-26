package demo08_tcp_while;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte[] bytes = new byte[1024];
        int b;
//        while ((b = bis.read(bytes)) != -1){
//            bos.write(bytes,0,b);
//        }

        while ((b = bis.read()) != -1){
            bos.write(b);
        }

        System.out.println("上传成功！");
        socket.shutdownOutput();
        InputStream ris = socket.getInputStream();
        while ((b = ris.read(bytes)) != -1){
            System.out.println(new String(bytes,0,b));
        }
        bis.close();
        socket.close();

    }
}
