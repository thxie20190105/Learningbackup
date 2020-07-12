package com.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/7/2
 **/
public class TestZk {
    private static String connectString = "192.168.17.17:2181,192.168.17.18:2181,192.168.17.19:2181,192.168.17.20:2181";

    private static int sessionTimeout = 2000;

    private static ZooKeeper zooKeeper;


    /**
     * 一个连接线程 一个监听线程
     *
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //watcher 监听回调
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/", true);
                    for (String str : children) {
                        System.out.println(str);
                    }
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * 创建一个节点
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void create() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/xigua", "thxie".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);

    }

    /**
     * 获取节点列表
     *
     * @throws KeeperException
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException, IOException {
        List<String> children = zooKeeper.getChildren("/", true);
        for (String str : children) {
            System.out.println(str);
        }
        System.in.read();
    }

    /**
     * 判断是否存在
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat exists = zooKeeper.exists("/xigua", false);
        System.out.println(exists == null ? "not exists" : "exists");
    }


}
