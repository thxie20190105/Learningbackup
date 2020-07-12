package org.xigua.study.mode.observer;

/**
 * @author xigua
 * @description
 * @date 2020/5/9
 **/
public class NewsPaperImpl2 implements NewsPaper {


    public NewsPaperShop newsPaperShop;

    public NewsPaperImpl2(NewsPaperShop newsPaperShop) {
        this.newsPaperShop = newsPaperShop;
        newsPaperShop.registered(this);
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
