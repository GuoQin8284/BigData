package Demo15_httpSocket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpResponse {
    private String version;
    private String status;
    private String uri;
    private SelectionKey selectionKey;
    private String content;

    public SelectionKey getSelectionKey() {
        return selectionKey;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    public void setContent(String content) {
        this.content = content;
        hs.put("Content-Type",content);
    }

    public HttpResponse(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    private HashMap<String, String> hs = new HashMap<>();
    private HttpRequest httpRequest;

    public void sendStaticResource(){
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        this.version = "HTTP/1.1";
        this.status = "200";
        this.uri = "/";
        String responseLine = this.version+ " " + this.status + " " +this.uri;
        StringBuilder sb = new StringBuilder();

        String uri = httpRequest.getUri();
        System.out.println("uri="+uri);
        if (uri != null) {
            if ("/".equals(uri)){
                hs.put("Content-Type", "text/html;chatset=UTF-8");
            }else if ("/favicon.ico".equals(uri)){
                hs.put("Content-Type", "image/icon");
            }else if ("/1.txt".equals(uri)){
                hs.put("Content-Type", "text/html;chatset=UTF-8");
            }else if ("/a.png".equals(uri)){
                hs.put("Content-Type", "image/png");
            }
        }

        Set<Map.Entry<String, String>> entries = hs.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        String empty = "\r\n";
        String responseLineStr = responseLine + sb.toString() + empty;

        try {
            ByteBuffer byteBuffer = ByteBuffer.wrap(responseLineStr.getBytes(StandardCharsets.UTF_8));
            socketChannel.write(byteBuffer);

            byte[] content = getContent();
            socketChannel.write(ByteBuffer.wrap(content));
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(){


    }

    private byte[] getContent() {
        String uri = this.httpRequest.getUri();
        if (uri != null) {
            String resourcePath = "ThreadTest\\webapp" + uri;
            System.out.println("资源路径为="+resourcePath);
            if ("/".equals(uri)){
                return "哈哈哈，终于写完了！".getBytes(StandardCharsets.UTF_8);
            }else {
                try {
                    byte[] bytes = new byte[8192];
                    int len;
                    FileInputStream fileInputStream = new FileInputStream(resourcePath);
                    while ((len = fileInputStream.read(bytes)) != -1){
                        return bytes;
                    }
                    fileInputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", uri='" + uri + '\'' +
                ", hs=" + hs +
                ", httpRequest=" + httpRequest +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HashMap<String, String> getHs() {
        return hs;
    }

    public void setHs(HashMap<String, String> hs) {
        this.hs = hs;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
}
