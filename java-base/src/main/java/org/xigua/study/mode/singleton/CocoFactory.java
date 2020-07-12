package org.xigua.study.mode.singleton;

/**
 * @author xigua
 * @description 练习单利模式
 * @date 2020/5/13
 **/
public class CocoFactory {
    private static CocoFactory cocoFactory;

    private CocoFactory() {
    }


    /**
     * 使用双重检查加锁。
     *
     * @return
     */
    public static CocoFactory getInstance() {
        if (cocoFactory == null) {
            synchronized (CocoFactory.class) {
                if (cocoFactory == null) {
                    cocoFactory = new CocoFactory();
                }
            }
        }
        return cocoFactory;
    }
}
