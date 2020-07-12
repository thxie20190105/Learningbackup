package org.xigua.study.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xigua
 * @description 练习NIO
 * @date 2020/5/4
 **/
public class TestNio {

    /**
     * 定义端口
     */
    private int port;
    /**
     * 定义选择器
     */
    private Selector selector;
    /**
     * 定义线程池
     */
    private ExecutorService ThreadPool = Executors.newFixedThreadPool(5);


    public TestNio(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new TestNio(8090).start();
    }

    public void start() {
        this.init();
        while (true) {
            try {
                //得到操作集已更新的键的数量，可能为零，会阻塞在这里
                int events = selector.select();
                if (events > 0) {
                    //得到可操作的操作集
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();

                    while (selectionKeys.hasNext()) {
                        SelectionKey selectionKey = selectionKeys.next();
                        selectionKeys.remove();
                        if (selectionKey.isAcceptable()) {//如果是请求连接事件，把它的状态变成可读状态。
                            accept(selectionKey);
                        } else if (selectionKey.isReadable()){//启动一个新线程去进行读写操作
                            ThreadPool.submit(new NioServerHandler(selectionKey));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey selectionKey) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            //将一个可读的通道注册到通道管理器中。
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("accept a client" + socketChannel.socket().getInetAddress().getHostName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化ServerSocketChannel
     */
    private void init() {
        ServerSocketChannel serverSocketChannel;
        try {
            //打开channel信道
            serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定socket端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            //打开selector通道管理器
            selector = Selector.open();
            //将通道与对应事件注册到通道管理器中，有新事件时selector.select()有返回
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("NioServer started");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class NioServerHandler implements Runnable {

        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {
                //判断是否是可读的状态
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    //分配一个1024字节的缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    byteBuffer.flip();
                    System.out.println("接收客户端请求" + socketChannel.socket().getInetAddress().getHostName());
                    //将字节数组包装到缓冲区当中
                    ByteBuffer outBuffer = ByteBuffer.wrap(byteBuffer.array());
                    socketChannel.write(outBuffer);
                    //取消这个键
                    selectionKey.cancel();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
