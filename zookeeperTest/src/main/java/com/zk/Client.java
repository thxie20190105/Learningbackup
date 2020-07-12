package com.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/7/2
 **/
public class Client {

    private static ZooKeeper zooKeeper;


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //1、获取连接
        System.out.println(Integer.MIN_VALUE);
        Client.getConnect();

        //2、注册监听
        Client.getChlidren();

        //3、业务逻辑处理
        Client.business();
    }

    private static void business() throws IOException {
        System.in.read();
    }

    private static void getChlidren() throws KeeperException, InterruptedException {
        String node = "/servers";

        //true注册监听之后会走到下面的process 的回调方法。
        List<String> children = zooKeeper.getChildren(node, true);

        //存储节点信息
        List list = new ArrayList();

        for (String str : children) {
            byte[] data = zooKeeper.getData(node + "/" + str, false, null);
            list.add(new String(data));
        }

        System.out.println(list);
    }


    private static void getConnect() throws IOException {
        String connectString = "192.168.17.17:2181,192.168.17.18:2181,192.168.17.19:2181,192.168.17.20:2181";
        int sessionTimeout = 2000;

        zooKeeper = new ZooKeeper(connectString, sessionTimeout, event -> {
            try {
                Client.getChlidren();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}
