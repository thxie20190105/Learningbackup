package org.xigua.study.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xigua
 * @description
 * @date 2020/5/4
 **/
public class TestNioClient {
    private static final String host = "127.0.0.1";
    private static final int port = 8090;
    private Selector selector;


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                TestNioClient testNioClient = new TestNioClient();
                testNioClient.connect(host, port);
                testNioClient.listen();
            });
        }
    }

    private void listen() {
        while (true) {
            try {
                int events = selector.select();
                if (events > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        //如果是连接事件
                        if (selectionKey.isConnectable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            //如果是处于连接等待事件中
                            if (socketChannel.isConnectionPending()) {
                                socketChannel.finishConnect();
                            }
                        } else if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            socketChannel.read(byteBuffer);
                            byteBuffer.flip();
                            System.out.println("收到服务端的数据" + new String(byteBuffer.array()));

                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 连接socket服务端
     *
     * @param host
     * @param port
     */
    private void connect(String host, int port) {
        try {
            //建立socket通道
            SocketChannel socketChannel = SocketChannel.open();
            //设置非阻塞
            socketChannel.configureBlocking(false);
            //打开selector选择器
            this.selector = Selector.open();

            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            //打开socket连接通道
            socketChannel.connect(new InetSocketAddress(host, port));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
