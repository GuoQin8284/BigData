package Demo09_tcp_Thread;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable{
    private Socket accept;

    public ThreadSocket(Socket acceptSocket){
        this.accept = acceptSocket;
    }
    @Override
    public void run() {
        UUID uuid = UUID.randomUUID();
        BufferedOutputStream bos = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream("C:\\"+ uuid.toString() +".mp4"));
            byte[] bytes = new byte[1024];
            int b;
            while ((b = bis.read(bytes)) != -1){
                bos.write(bytes,0,b);
            }
            OutputStream outputStream = accept.getOutputStream();
            String res = "接收成功！";
            outputStream.write(res.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
