package org.xigua.study.javabase.net.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author xigua
 * @description 使用java自带的net包下面功能实现，通过url对象返回一个http 的对象
 * @date 2020/5/31
 **/
public class TestHttpForJavaNet {
    public static void main(String[] args) {
        HttpURLConnection connection;
        OutputStream outputStream;
        InputStream inputStream;
        String addr2 = "http://220.181.38.148:80";
        int timeOut = 1000 * 30;
        try {
            URL url = new URL(addr2);
            connection = (HttpURLConnection) url.openConnection();
            //设置连接与读取超时
            connection.setConnectTimeout(timeOut);
            connection.setReadTimeout(timeOut);
            //连接后是否会使用输入
            connection.setDoInput(true);
            //连接后是否会使用输出
            connection.setDoOutput(true);
            //设置请求类型
            connection.setRequestMethod("POST");
            //设置请求属性
            connection.setRequestProperty("Content-type", "application/xml");


            //输出
            outputStream = connection.getOutputStream();
            outputStream.write(new byte['a']);
            outputStream.flush();

            //输入
            inputStream = new BufferedInputStream(connection.getInputStream());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(len);
                System.out.println(new String(bytes, 0, len));
            }


        } catch (MalformedURLException e) {
            System.out.println("URL格式错误");
        } catch (ProtocolException e) {
            System.out.println("设置请求方法异常");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
