package org.chm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by charming on 2017/2/15.
 */
public class ServerTest1 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel outChannel = ServerSocketChannel.open();
            FileChannel fileChannel = FileChannel.open(Paths.get("mina2.png"),StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            outChannel.bind(new InetSocketAddress(8989));
            //获取客户端连接通道
            SocketChannel socketChannel = outChannel.accept();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (socketChannel.read(buf) != -1)
            {
                buf.flip();
                fileChannel.write(buf);
                buf.clear();
            }

            socketChannel.close();
            fileChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
