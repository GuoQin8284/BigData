package demo03_udp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\socket.txt",false));

        DatagramSocket ds = new DatagramSocket(8080);

        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);

        while (true) {
            ds.receive(dp);
            byte[] data1 = dp.getData();
            int length = dp.getLength();
            fileOutputStream.write(data1,0,length);
            String s = new String(data1, 0, length);
            System.out.println(s);
            if (s.equals("1000000")){
                System.out.println("已经到了1000000，接收结束");
                break;
            }
        }
        ds.close();
    }

    private static void rec_method() throws IOException {
        DatagramSocket ds = new DatagramSocket(8080);

        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);

        while (true) {
            ds.receive(dp);

            byte[] data1 = dp.getData();
            int length = dp.getLength();
            System.out.println(new String(data1,0, length));
        }
    }
}
