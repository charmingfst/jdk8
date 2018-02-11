package org.chm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by charming on 2017/2/15.
 */
public class ClentTest2 {
    public static void main(String[] args) {
        try {
            SocketChannel inChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));

            inChannel.configureBlocking(false);

            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext())
            {
                String str = scanner.nextLine();
                buf.put((LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"+str).getBytes());
                buf.flip();
                inChannel.write(buf);
                buf.clear();
            }
            inChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
