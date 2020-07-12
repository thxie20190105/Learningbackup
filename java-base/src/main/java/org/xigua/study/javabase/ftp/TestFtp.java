package org.xigua.study.javabase.ftp;

import org.xigua.util.net.FtpClientUtil;

/**
 * @author org.xigua
 */
public class TestFtp {

    public static void main(String[] args) {

        String hostname = "192.168.17.17";
        int port = 22;
        String username = "mysftp";
        String password = "mysftp";
        String pathname = "/upload";
        String filename = "aa.txt";
        String localpath = "D:/";
        long stratTime = System.currentTimeMillis();
        //apache net 不支持ssh2.0的方式因为他是个ftp的，jSch是sftp的
        FtpClientUtil.downloadFile(hostname, port, username, password, pathname, filename, localpath);
        long endtime = System.currentTimeMillis();
        System.out.println("花费时间" + (endtime - stratTime) / 1000 + "秒");
    }

}
