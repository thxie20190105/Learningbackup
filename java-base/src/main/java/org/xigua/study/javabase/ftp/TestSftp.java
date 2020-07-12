package org.xigua.study.javabase.ftp;

import org.xigua.util.net.SftpClientUtil;

/**
 * @author org.xigua
 */
public class TestSftp {
    private static final String PATH_NAME = "/upload";
    private static final String FILE_NAME = "aa.txt";
    private static final String LOCAL_PATH = "D:/";


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int i = 2;
        while (i != 0) {

            SftpClientUtil.downloadFile(SftpClientUtil.getSftp(), FILE_NAME, PATH_NAME);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i--;
        }


        long endTime = System.currentTimeMillis();
        System.out.println("花费时间" + (endTime - startTime) / 1000 + "秒");
    }

}
