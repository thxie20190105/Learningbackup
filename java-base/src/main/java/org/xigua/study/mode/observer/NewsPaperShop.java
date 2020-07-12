package org.xigua.study.mode.observer;

/**
 * @author xigua
 * @description
 * @date 2020/5/9
 **/
public interface NewsPaperShop {
    void update();

    void registered(NewsPaper newsPaper);

    void remove(NewsPaper newsPaper);


}

