package org.xigua.study.mode.observer;

/**
 * @author xigua
 * @description
 * @date 2020/5/9
 **/
public class Test {
    public static void main(String[] args) {

        NewsPaperShop newsPaperShop = new NewsPaperShopImpl();

        NewsPaperImpl1 newsPaperImpl1 = new NewsPaperImpl1(newsPaperShop);
        NewsPaperImpl2 newsPaperImpl2 = new NewsPaperImpl2(newsPaperShop);
        NewsPaperImpl3 newsPaperImpl3 = new NewsPaperImpl3(newsPaperShop);


        newsPaperShop.update();
    }
}
