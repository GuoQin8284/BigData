package demo05_udp_gaungbo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        rec_method();
    }

    private static void rec_method() throws IOException {
        DatagramSocket ds = new DatagramSocket(8080);

        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);

        ds.receive(dp);
        byte[] data1 = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(data1,0, length));

        ds.close();
    }
}
