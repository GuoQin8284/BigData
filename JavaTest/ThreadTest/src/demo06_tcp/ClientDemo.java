package demo06_tcp;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream os = socket.getOutputStream();
        FileInputStream fs = new FileInputStream("D:\\socket.txt");
        byte[] bytes = new byte[1024];
        int b;
        while (true)
            if ((b=fs.read(bytes)) != -1) {
                os.write(bytes,0,b);
            }else {
                break;
            }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        while (true){
            if ((b=inputStream.read(bytes))!= -1){
                System.out.println(new String(bytes,0,b));
            }else {
                break;
            }
        }
        fs.close();
        os.close();
        socket.close();
    }
}
