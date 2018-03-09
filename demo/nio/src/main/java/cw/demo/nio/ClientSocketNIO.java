package cw.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientSocketNIO {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 2000);
        boolean connect = channel.connect(socketAddress);
        channel.register(selector, SelectionKey.OP_CONNECT);

        int select = selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            SocketChannel channel1 = (SocketChannel) next.channel();
            iterator.remove();

            if (next.isConnectable()) {
                if (channel1.isConnectionPending()) {
                    if (channel1.finishConnect()) {
                        next.interestOps(SelectionKey.OP_READ);
                        byteBuffer.put("123456789abcdefghijklmnopq".getBytes());
                        byteBuffer.flip();
                        channel1.write(byteBuffer);
                        System.out.println("写入完毕");
                    } else {
                        System.out.println("cancel");
                        next.cancel();
                    }
                }
            }
        }
    }
}
