package Demo12_NioSocket;

import sun.misc.JavaNioAccess;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            if (accept != null){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len = accept.read(byteBuffer);
                System.out.println(new String(byteBuffer.array(),0,len));
            }
        }

    }
}
