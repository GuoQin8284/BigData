package demo03_udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        for (int i = 0; i <= 1000000; i++) {
            String s = "中国"+ i;
            if (i == 1000000){
                s = String.valueOf(i);
                System.out.println("s:"+s);
            }
            byte[] data = s.getBytes();
            InetAddress address = InetAddress.getByName("192.168.1.6");
            int port = 8080;
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);

            ds.send(datagramPacket);
        }
        ds.close();


    }

    private static void sendMethod01() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "中国";
        byte[] data = s.getBytes();
        InetAddress address = InetAddress.getByName("192.168.1.6");
        int port = 8080;
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);

        ds.send(datagramPacket);
        ds.close();
    }
}
