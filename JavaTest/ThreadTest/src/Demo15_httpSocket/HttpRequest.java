package Demo15_httpSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

public class HttpRequest {
    private String method;
    private String uri;
    private String status;
    private HashMap<String, String> hs = new HashMap<>();
    private SelectionKey selectionKey;

    public HttpRequest(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    public StringBuilder parse(){
//        SocketChannel socketChannel1 = null;
        try {
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            StringBuilder stringBuilder = new StringBuilder();
            int len;
            while ((len = socketChannel.read(byteBuffer)) > 0){
                byteBuffer.flip();
                stringBuilder.append(new String(byteBuffer.array(),0,len));
                byteBuffer.clear();
            }
            parseHeader(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void parseHeader(StringBuilder stringBuilder){
        String httpRequsetStr = stringBuilder.toString();
        if (!(httpRequsetStr == null || "".equals(httpRequsetStr))){
            String[] splits = httpRequsetStr.split("\r\n");
            String[] requsetLine = splits[0].split(" ");
            this.setMethod(requsetLine[0]);
            this.setUri(requsetLine[1]);
            this.setStatus(requsetLine[2]);
            int length = splits.length;
            for (int i = 1; i < length; i++) {
                String[] split = splits[i].split(": ");
                hs.put(split[0], split[1]);
            }
        }
    }
    
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", status='" + status + '\'' +
                ", hs=" + hs +
                '}';
    }
}
