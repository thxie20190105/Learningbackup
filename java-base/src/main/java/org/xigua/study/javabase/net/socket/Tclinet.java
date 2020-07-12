package org.xigua.study.javabase.net.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author org.xigua
 */
public class Tclinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("0.0.0.0", 8888);
        OutputStream outputStream = socket.getOutputStream();
        Socket socket1 = new Socket("0.0.0.0", 8888);
        OutputStream outputStream1 = socket.getOutputStream();
        outputStream.write(new byte['a']);
        outputStream1.write(new byte['k']);


        outputStream.close();
        socket.close();
    }
}
