package org.xigua.study.mode.decorator.decorator;

import org.xigua.study.mode.decorator.Beverage;
import org.xigua.study.mode.decorator.CondimentDecorator;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "Mocha";
    }

    @Override
    public double cost() {
        if (beverage.TALL == 2) {
            return 999 + beverage.cost();
        }
        return 0.99 + beverage.cost();
    }
}
