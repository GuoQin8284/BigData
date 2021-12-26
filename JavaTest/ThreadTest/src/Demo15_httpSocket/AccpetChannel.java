package Demo15_httpSocket;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AccpetChannel {
    public SocketChannel connSocketChannel(SelectionKey selectionKey){
        try {
            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel1.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
            return socketChannel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
