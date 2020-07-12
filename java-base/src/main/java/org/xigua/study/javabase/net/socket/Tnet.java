package org.xigua.study.javabase.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author org.xigua
 */
public class Tnet {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.163.com");
        System.out.println(inetAddress);

        InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress1);

        InetAddress inetAddress2 = InetAddress.getLocalHost();
        System.out.println(inetAddress2);

        String host = inetAddress2.getHostName();
        System.out.println("域名:" + host);

        String ip = inetAddress2.getHostAddress();
        System.out.println("ip:" + ip);

        //java对socket进行了高度的封装，优点是简化了难度，缺点是对网络底层的系统编程比较困难
        //无法实现网络嗅探、以及获得ip包结构等信息


        Tnet.testSocket();

    }

    private static void testSocket() throws IOException {
        //socket代表客户端连接
        //表示客户端创建于服务端的网络连接
        System.out.println("建立客户端的网络连接");
        Socket socket1 = new Socket("www.csdn.net", 80);
        //建立数据流
        OutputStream outputStream = socket1.getOutputStream();
        InputStream inputStream = socket1.getInputStream();
        //操作.....

        outputStream.write("22".getBytes());

        System.out.println("接收服务端数据");
        byte[] b = new byte[1024];
        int n;
        while ((n = inputStream.read(b)) != -1) {
            System.out.println(new String(b, 0, n));
        }

        //操作后释放资源
        outputStream.close();
        inputStream.close();
        socket1.close();


    }
}
