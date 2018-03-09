package cw.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketNIO {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
//        int[] ports = {2000, 2001, 2002, 2003, 2004};
//        for (int i = 0; i < 5; i++) {
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        SocketAddress socketAddress = new InetSocketAddress(2000);
        serverSocket.bind(socketAddress);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//        }

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    System.out.println("---------accept");
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                } else if (next.isReadable()) {
                    System.out.println("----------read");
                    SocketChannel channel = (SocketChannel) next.channel();
                    while (true) {
                        byteBuffer.clear();
                        int read = channel.read(byteBuffer);
                        if (read <= 0) {
                            channel.close();
                            break;
                        }
                        System.out.println("##" + read + " " + new String(byteBuffer.array(), 0, byteBuffer.position()));
                        byteBuffer.flip();
//                        channel.write(byteBuffer);
                        System.out.println("------------");
                    }
                    iterator.remove();
                } else {
                    next.channel().close();
                }
            }
        }
    }
//
//    public static void main(String[] args) throws IOException {
//        ByteBuffer echoBuffer = ByteBuffer.allocate(8);
//        ServerSocketChannel ssc = ServerSocketChannel.open();
//        Selector selector = Selector.open();
//        ssc.configureBlocking(false);
//        ServerSocket ss = ssc.socket();
//        InetSocketAddress address = new InetSocketAddress(2000);
//        ss.bind(address);
//        SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
//        System.out.println("开始监听……");
//        while (true) {
//            int num = selector.select();
//            Set selectedKeys = selector.selectedKeys();
//            Iterator it = selectedKeys.iterator();
//            while (it.hasNext()) {
//                SelectionKey sKey = (SelectionKey) it.next();
//                SocketChannel channel = null;
//                if (sKey.isAcceptable()) {
//                    ServerSocketChannel sc = (ServerSocketChannel) key.channel();
//                    channel = sc.accept();// 接受连接请求
//                    channel.configureBlocking(false);
//                    channel.register(selector, SelectionKey.OP_READ);
//                    it.remove();
//                } else if (sKey.isReadable()) {
//                    channel = (SocketChannel) sKey.channel();
//                    while (true) {
//                        echoBuffer.clear();
//                        int r = channel.read(echoBuffer);
//                        if (r <= 0) {
//                            channel.close();
//                            System.out.println("接收完毕，断开连接");
//                            break;
//                        }
//                        System.out.println("##" + r + " " + new String(echoBuffer.array(), 0, echoBuffer.position()));
//                        echoBuffer.flip();
//                    }
//                    it.remove();
//                } else {
//                    channel.close();
//                }
//            }
//        }
//
//    }
}
