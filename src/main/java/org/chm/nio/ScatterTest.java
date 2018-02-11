package org.chm.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by charming on 2017/2/15.
 */
public class ScatterTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
            FileChannel fileChannel = raf.getChannel();

            ByteBuffer buf1 = ByteBuffer.allocate((int) (fileChannel.size() / 2));
            ByteBuffer buf2 = ByteBuffer.allocate((int) (fileChannel.size() / 2) + 1);
            ByteBuffer[] bufs = {buf1, buf2};
            //分散读取
            fileChannel.read(bufs);
            for (ByteBuffer buf : bufs) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, buf.limit()));
                buf.clear();
            }
            fileChannel.close();

            RandomAccessFile raf2 = new RandomAccessFile("test2.txt", "rw");
            FileChannel outChannel = raf2.getChannel();
            //聚集写入
            outChannel.write(bufs);
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
