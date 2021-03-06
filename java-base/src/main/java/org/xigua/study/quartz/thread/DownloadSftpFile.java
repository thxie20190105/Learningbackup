package org.xigua.study.quartz.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xigua
 * @description
 * @date 2020/4/30
 **/
public class DownloadSftpFile implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadSftpFile.class);

    private String fileName;

    public DownloadSftpFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        LOGGER.info("当前线程" + Thread.currentThread().getName());
        LOGGER.info("下载文件名称" + fileName);
/*
        ChannelSftp sftp = SftpClientUtil.getSftp();

        InputStream inputStream = SftpClientUtil.downloadFile(sftp, fileName, "/");

        String filepath = SaveFileAndEncryptAndDecode.saveEncryptFile(inputStream,fileName);

        SaveFileAndEncryptAndDecode.decode(filepath);

        //关闭连接
        SftpClientUtil.close(sftp);*/


    }
}
