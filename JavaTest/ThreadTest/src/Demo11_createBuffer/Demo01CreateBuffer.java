package Demo11_createBuffer;

import java.nio.ByteBuffer;

public class Demo01CreateBuffer {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        for (int i = 0; i < 1024; i++) {
            System.out.println(wrap.get());
        }
    }

    private static void create01_method() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer.get());
        }
    }
}
