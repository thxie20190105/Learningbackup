package org.xigua.study.mode.decorator;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public abstract class Beverage {
    public String description = " UnKnown Beverage";
    public int TALL = 0;

    public String getDescription() {
        return description;
    }

    public abstract double cost();


}
