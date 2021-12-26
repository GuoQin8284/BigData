package demo18_httpServer.HttpServlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int count = selector.select();
            if (count > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()){
                        AccpetChannel accpetChannel = new AccpetChannel();
                        accpetChannel.connSocketChannel(selectionKey);
                    }else if (selectionKey.isReadable()){
                        HttpRequest httpRequest = new HttpRequest(selectionKey);
                        httpRequest.parse();
                        System.out.println(httpRequest.toString());
                        if ((httpRequest.getUri() == null || "".equals(httpRequest.getUri()))) {
                            selectionKey.channel();
                            continue;
                        }

                        HttpResponse httpResponse = new HttpResponse(selectionKey);
                        httpResponse.setHttpRequest(httpRequest);
                        if (httpRequest.getUri().startsWith("/servlet")){
                            DynamicResponseProcess dynamicResponseProcess = new DynamicResponseProcess();
                            dynamicResponseProcess.process(httpRequest,httpResponse);
                        }else {
                            httpResponse.sendStaticResource();
                        }
                    }
                }
                iterator.remove();
            }
        }
    }
}
