package demo04_udp_mutil;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String sendData = "哈哈，组播";
        byte[] bytes = sendData.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 8080);
        ds.send(dp);
        ds.close();
    }
}
