package demo04_udp_mutil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket mu = new MulticastSocket(8080);

        mu.joinGroup(InetAddress.getByName("224.0.1.0"));
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        mu.receive(dp);
        byte[] data = dp.getData();
        String rec_str = new String(data, 0, dp.getLength());
        System.out.println(rec_str);
        mu.close();
    }
}
