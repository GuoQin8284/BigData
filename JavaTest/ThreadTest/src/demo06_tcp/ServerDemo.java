package demo06_tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while (true){
            if ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }else {
                break;
            }
        }
        OutputStream outputStream = accept.getOutputStream();
        String msg = "收到了";
        outputStream.write(msg.getBytes());
//        while (true){
//            int readCount = inputStream.read(bytes);
//            if (readCount == -1){
//                break;
//            }
//            System.out.println(new String(bytes));
//        }
        inputStream.close();
        serverSocket.close();
    }
}
