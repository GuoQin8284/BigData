package Demo13_NioSocket02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("客户端的数据".getBytes());
        socketChannel.write(byteBuffer1);
        socketChannel.shutdownOutput();

        int len;
        byteBuffer1.clear();
        while ((len = socketChannel.read(byteBuffer1)) != -1){
            byteBuffer1.flip();
            System.out.println("len="+len);
            System.out.println(new String(byteBuffer1.array(), 0 ,len));
            byteBuffer1.clear();
        }
        socketChannel.close();
    }
}
