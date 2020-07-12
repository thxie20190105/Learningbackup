package org.xigua.study.javabase.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author org.xigua
 */
public class Tscoket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println(serverSocket.getInetAddress());
        Socket socket;
        InputStream inputStream;
        OutputStream outputStream;
        while (true) {
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //来一个就把一个线程扔到线程池里
            new WorkThread(inputStream).start();

        }
    }


    static class WorkThread extends Thread {

        private InputStream inputStream;

        public WorkThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            try {
                System.out.println(inputStream.read(new byte[1024]));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

