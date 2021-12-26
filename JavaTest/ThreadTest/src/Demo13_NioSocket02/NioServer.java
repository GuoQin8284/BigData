package Demo13_NioSocket02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        while (true){
            SocketChannel accept = serverSocketChannel.accept();
            if (accept != null) {
                System.out.println("有客户端连接");
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len;
                while ((len = accept.read(byteBuffer)) != -1) {
                    System.out.println("服务端已接收到数据");
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(), 0, len));
                    byteBuffer.clear();
//                    byteBuffer.position(0);
                }
                System.out.println("服务端准备回写数据");
                ByteBuffer byteBuffer1 = ByteBuffer.wrap("服务端已回写".getBytes());
                accept.write(byteBuffer1);
                accept.shutdownOutput();
            }
        }
    }
}
