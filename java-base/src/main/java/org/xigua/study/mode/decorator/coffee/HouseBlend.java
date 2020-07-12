package org.xigua.study.mode.decorator.coffee;

import org.xigua.study.mode.decorator.Beverage;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.1;
    }
}
