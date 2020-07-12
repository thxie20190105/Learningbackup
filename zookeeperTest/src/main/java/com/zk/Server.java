package com.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/7/2
 **/
public class Server {

    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //1、获取连接
        Server.getConnect();

        //2、注册节点
        Server.regist(args[0]);

        //3、业务逻辑处理
        Server.business();
    }

    private static void business() throws IOException {
        System.in.read();
    }

    /**
     * 带编号的节点
     * 临时的节点
     *
     * @param hostName
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void regist(String hostName) throws KeeperException, InterruptedException {
        String node = "/servers/server";

        String path = zooKeeper.create(node,
                hostName.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(path + "is online");
    }

    private static void getConnect() throws IOException {
        String connectString = "192.168.17.17:2181,192.168.17.18:2181,192.168.17.19:2181,192.168.17.20:2181";
        int sessionTimeout = 2000;

        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {


            }
        });
    }


}
