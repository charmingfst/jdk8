package org.chm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.channels.SocketChannel.open;

/**
 * Created by charming on 2017/2/15.
 */
public class ClientTest1 {
    public static void main(String[] args) {
        try {
            SocketChannel inChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));

            FileChannel fileChannel = FileChannel.open(Paths.get("mina.png"), StandardOpenOption.READ);

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (fileChannel.read(buf) != -1)
            {
                buf.flip();
                inChannel.write(buf);
                buf.clear();
            }

            fileChannel.close();
            inChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
