package org.xigua.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 主要功能包括，获取客户端IP，服务器IP和服务器主机名。
 *
 * @author org.xigua
 */
public class EnvironmentUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentUtil.class);
    private static List<String> listIP4 = new ArrayList<String>();

    static {
        listIP4.addAll(getIp4());
    }

    private EnvironmentUtil() {
    }

    /**
     * 获取主机的IP地址
     *
     * @return
     */
    public static List<String> getIp4() {
        List<String> list = new ArrayList<String>();
        Enumeration<NetworkInterface> nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            LOGGER.error("getIp4失败", ex);
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = nis.nextElement();
            Enumeration<InetAddress> ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = ias.nextElement();
                if ((ia instanceof Inet4Address) && !ia.isLoopbackAddress()) {
                    String ip = ia.getHostAddress();
                    if (ip != null && (!list.contains(ip))) {
                        list.add(ip);
                    }
                }
            }
        }
        return list;
    }

    public static List<String> getIp4FromCache() {
        return listIP4;
    }

    public static String getIp4First() {
        String str = null;
        Enumeration<NetworkInterface> nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            LOGGER.error("getIp4First失败", ex);
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = nis.nextElement();
            Enumeration<InetAddress> ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = ias.nextElement();
                if ((ia instanceof Inet4Address) && !ia.isLoopbackAddress()) {
                    String ip = ia.getHostAddress();
                    if (ip != null) {
                        str = ip;
                        break;
                    }
                }

            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    /**
     * 获取当前服务器的主机名 <br>
     * <font color="red">当linux主机配置了/ect/hosts文件，可能会影响取值</font>
     *
     * @return 主机名
     */
    public static final String getHostName() {
        String hostName = "";
        InetAddress ia;
        try {
            ia = InetAddress.getLocalHost();
            hostName = ia.getHostName();
        } catch (UnknownHostException e) {
            LOGGER.debug("获取当前服务器的主机名", e);
        }

        return hostName;
    }

    public static String getIp4FirstFromCache() {
        return listIP4.isEmpty() ? null : listIP4.get(0);
    }

}
