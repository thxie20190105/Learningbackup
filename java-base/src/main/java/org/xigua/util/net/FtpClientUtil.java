package org.xigua.util.net;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author org.xigua
 */
public class FtpClientUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FtpClientUtil.class);

	FtpClient ftpClient;

	/**
	 * 连接FTP服务
	 * 
	 * @param ip       FTP服务IP地址
	 * @param port     FTP服务端口
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 * @throws IOException
	 */
	public static FtpClient connectFtp(String ip, int port, String userName, String password) throws IOException {
		FtpClient ftp = null;
		try {
			SocketAddress addr = new InetSocketAddress(ip, port);
			ftp = FtpClient.create();
			ftp.connect(addr);
			// 登陆
			ftp.login(userName, password.toCharArray());
			ftp.setBinaryType();

		} catch (FtpProtocolException e) {
			LOGGER.debug("连接FTP异常", e);
		} catch (IOException e) {
			LOGGER.debug("连接FTP异常", e);
		}
		return ftp;
	}

	/**
	 * 获取FTP上指定文件的文件内容
	 * 
	 * @param ftpFile 文件路径
	 * @param ftp
	 * @return
	 * @throws IOException
	 */
	public static List<String> download(String ftpFile, FtpClient ftp) throws IOException {
		List<String> list = new ArrayList<String>();
		String str = "";
		InputStream is = null;
		BufferedReader br = null;
		try {
			// 获取ftp上的文件
			is = ftp.getFileStream(ftpFile);
			// 转为字节流
			br = new BufferedReader(new InputStreamReader(is));
			while ((str = br.readLine()) != null) {
				list.add(str);
			}

			br.close();
			is.close();
		} catch (Exception e) {
			LOGGER.debug("获取FTP上指定文件的文件内容失败", e);
		} finally {
			if (null != br || null != is) {
				br.close();
				is.close();
			}
		}
		return list;
	}


	public static boolean downloadFile(String hostname, int port, String username, String password, String pathname, String filename, String localpath) {
		boolean flag = false;
		FTPClient ftpClient = new FTPClient();
		try {
			//����FTP������
			ftpClient.connect(hostname, port);
			//��¼FTP������
			ftpClient.login(username, password);
			//��֤FTP�������Ƿ��¼�ɹ�
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				return flag;
			}
			//�л�FTPĿ¼
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.enterLocalPassiveMode();
			FTPFile[] ftpFiles = ftpClient.listFiles();


			for (FTPFile file : ftpFiles) {

				System.out.println("�ļ���С" + (file.getSize() / 1024 / 1024) + "M");

				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());

					OutputStream os = new FileOutputStream(localFile);
					InputStream input = ftpClient.retrieveFileStream(file.getName());

					byte[] b = new byte[1024];
					int length = 0;
					while ((length = input.read(b)) != -1) {
						os.write(b, 0, length);
					}
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.logout();
				} catch (IOException e) {

				}
			}
		}
		return flag;
	}

}
