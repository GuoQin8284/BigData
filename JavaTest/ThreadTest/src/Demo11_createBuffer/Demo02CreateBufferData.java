package Demo11_createBuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Demo02CreateBufferData {
    public static void main(String[] args) {
        ByteBuffer btl = ByteBuffer.allocate(10);
//        btl.put((byte) 97);
//        System.out.println(btl.position());
//        System.out.println(btl.limit());
//        System.out.println(btl.capacity());

        btl.put("aaaa".getBytes());
        System.out.println(btl.position());
        System.out.println(btl.limit());
        System.out.println(btl.capacity());

        System.out.println("------------------------");

        btl.position(5);
        btl.limit(9);
        btl.put((byte) 55);
        System.out.println(btl.position());
        System.out.println(btl.limit());
        System.out.println(btl.capacity());
        System.out.println(btl.remaining());
        System.out.println(btl.hasRemaining());

    }
}
