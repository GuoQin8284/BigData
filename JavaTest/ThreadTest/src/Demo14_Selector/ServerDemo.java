package Demo14_Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            int count = selector.select();
            if (count != 0) {
                System.out.println("有客户端连接进来");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()){
                        ServerSocketChannel ssc = (ServerSocketChannel)selectionKey.channel();
                        SocketChannel socketChannel1 = ssc.accept();
                        socketChannel1.configureBlocking(false);
                        socketChannel1.register(selector, SelectionKey.OP_READ);
                    }else if (selectionKey.isReadable()){
                        SocketChannel socketChannel= (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len;
                        while ((len = socketChannel.read(byteBuffer)) > 0){
                            System.out.println(new String(byteBuffer.array(),0,len));
                        }
                        socketChannel.write(ByteBuffer.wrap("服务端已收到".getBytes(StandardCharsets.UTF_8)));
                        socketChannel.close();
                    }
                    iterator.remove();

                }
            }
        }

    }
}
