package org.xigua.study.mode.factory.store;

import org.xigua.study.mode.factory.pizza.Pizza;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        //使用工厂方法可以自定义创建pizza的过程
        pizza = createPizza(type);

        //使用抽象工厂方法
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;

    }

    protected abstract Pizza createPizza(String type);
}
