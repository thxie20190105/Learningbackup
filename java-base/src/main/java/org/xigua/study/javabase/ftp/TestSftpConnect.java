package org.xigua.study.javabase.ftp;

import com.jcraft.jsch.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xigua
 * @description
 * @date 2020/5/24
 **/
public class TestSftpConnect {
    public static Object object = new Object();
    private static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        for (int i = 0, j = 100; i < j; i++) {
            threadPoolExecutor.execute(new connect());
        }
        threadPoolExecutor.shutdown();

    }

}


class connect implements Runnable {

    @Override
    public void run() {
        try {
            String hostName = "192.168.17.17";
            String userName = "mysftp";
            String password = "mysftp";

            JSch jSch = new JSch();
            Session session = jSch.getSession(userName, hostName, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");

            channel.connect();
            ChannelSftp sftp = (ChannelSftp) channel;

            System.out.println("打开连接");
            // Thread.sleep(20000);
            System.out.println("关闭连接");

            //sftp.disconnect();
            //session.disconnect();

        } catch (JSchException e) {
            e.printStackTrace();
        }


    }
}
