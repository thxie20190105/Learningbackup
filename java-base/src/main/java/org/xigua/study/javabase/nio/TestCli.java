package org.xigua.study.javabase.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author xigua
 * @description
 * @date 2020/7/5
 **/
public class TestCli {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8090);
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(new byte['1']);
        TimeUnit.SECONDS.sleep(10);

        socket.close();
    }
}
