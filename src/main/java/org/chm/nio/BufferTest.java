package org.chm.nio;

import java.nio.ByteBuffer;

/**
 * Created by charming on 2017/2/14.
 */
public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("hello".getBytes());

        buf.flip();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes, 0, bytes.length);
        System.out.println(new String(bytes));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //clear() : 清空缓冲区. 但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        buf.clear();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        byte[] bytes2 = new byte[buf.limit()];
        buf.get(bytes2, 0, bytes.length);
        System.out.println(new String(bytes2));

    }
}
