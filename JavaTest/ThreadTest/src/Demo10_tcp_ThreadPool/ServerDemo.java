package Demo10_tcp_ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.*;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ThreadPoolExecutor thp = new ThreadPoolExecutor(3,10,10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );

        while (true){
            ThreadSocket t1 = new ThreadSocket(serverSocket.accept());
            thp.submit(t1);
        }

    }
}