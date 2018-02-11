package org.chm.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by charming on 2017/2/18.
 */
public class PipeTest {
    private Pipe pipe;

    public static void main(String[] args) {
        new PipeTest().testPipe();

    }

    public void testPipe2() {
        try {
            pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            buf.flip();

            while (buf.hasRemaining()) {
                sinkChannel.write(buf);
            }

            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buf1 = ByteBuffer.allocate(48);
            int bytesRead = sourceChannel.read(buf1);
            System.out.println(new String(buf1.array(), 0, bytesRead));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testPipe() {

        Thread thread1 = new Thread(() -> {
            try {
                pipe = Pipe.open();
                System.out.println("thread1");
                Pipe.SinkChannel sinkChannel = pipe.sink();
                ByteBuffer buf = ByteBuffer.allocate(1024);
                buf.clear();
                buf.put("hello pip".getBytes());
                buf.flip();

                while (buf.hasRemaining()) {
                    sinkChannel.write(buf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2");
            Pipe.SourceChannel sourceChannel = pipe.source();
            System.out.println();
            ByteBuffer buf = ByteBuffer.allocate(1024);
//                buf.flip();
            try {
                int len = sourceChannel.read(buf);
                System.out.println("len:" + len);
                System.out.println(new String(buf.array(), 0, len));
                sourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        thread1.start();
        thread2.start();
    }
}
