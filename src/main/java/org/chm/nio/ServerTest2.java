package org.chm.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by charming on 2017/2/15.
 */
public class ServerTest2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            ssChannel.configureBlocking(false);
            ssChannel.bind(new InetSocketAddress(8989));
            //获取选择器
            Selector selector = Selector.open();

            ssChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0)
            {
                //获取选择器中已就绪的监听事件
                Set<SelectionKey> set= selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext())
                {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable())
                    {
                        SocketChannel socketChannel = ssChannel.accept();
                        socketChannel.configureBlocking(false);
                        //读取通道数据，监控读就绪状态
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }else if (selectionKey.isReadable()) {
                        //获取选择器上准备就绪的通道
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int num = Integer.MAX_VALUE;
                        while ((num = socketChannel.read(buf)) != -1) {
                            System.out.println(num);
                            buf.flip();
                            System.out.println(new String(buf.array()));
                            buf.clear();
                        }
                    }
                    //取消选择键SelectionKey
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
