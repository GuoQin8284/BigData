package demo05_udp_gaungbo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        sendMethod01();
    }

    private static void sendMethod01() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "中国";
        byte[] data = s.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 8080;
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);

        ds.send(datagramPacket);
        ds.close();
    }
}
