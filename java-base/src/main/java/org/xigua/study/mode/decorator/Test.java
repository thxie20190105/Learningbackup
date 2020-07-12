package org.xigua.study.mode.decorator;

import org.xigua.study.mode.decorator.coffee.Espresso;
import org.xigua.study.mode.decorator.coffee.HouseBlend;
import org.xigua.study.mode.decorator.decorator.Mocha;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class Test {
    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1.TALL = 2;
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);

        System.out.println(beverage1.getDescription() + beverage1.cost());
    }

}
