package org.xigua.study.mode.decorator.coffee;

import org.xigua.study.mode.decorator.Beverage;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso Coffee";
    }

    @Override
    public double cost() {
        return 0.5;
    }
}
