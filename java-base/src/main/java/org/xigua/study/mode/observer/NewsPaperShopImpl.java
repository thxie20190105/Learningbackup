package org.xigua.study.mode.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/5/9
 **/
public class NewsPaperShopImpl implements NewsPaperShop {

    private List<NewsPaper> list = new ArrayList<NewsPaper>();

    private String msg = "信息";


    @Override
    public void update() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            NewsPaper newsPaper = (NewsPaper) iterator.next();
            newsPaper.print(msg);
        }

    }

    @Override
    public void registered(NewsPaper newsPaperImpl1) {
        list.add(newsPaperImpl1);
    }

    @Override
    public void remove(NewsPaper newsPaper) {
        list.remove(newsPaper);

    }
}
