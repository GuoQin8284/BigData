package Demo09_tcp_Thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            ThreadSocket t1 = new ThreadSocket(serverSocket.accept());
            Thread thread = new Thread(t1);
            thread.start();
        }

    }
}