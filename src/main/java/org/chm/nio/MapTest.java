package org.chm.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 * Created by charming on 2017/2/15.
 */
public class MapTest {
    public static void main(String[] args) {
        //使用直接缓冲区完成文件复制（内存映射文件）
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("mina.png"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("mina3.png"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] bytes = new byte[inMappedBuf.limit()];
            inMappedBuf.get(bytes);
            outMappedBuf.put(bytes);

            inChannel.close();
            outChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //利用通道完成文件的复制
        try {
            FileInputStream fis = new FileInputStream("mina.png");
            FileOutputStream fos = new FileOutputStream("mina4.png");

            //获取通道
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf) != -1)
            {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }

            inChannel.close();
            outChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
