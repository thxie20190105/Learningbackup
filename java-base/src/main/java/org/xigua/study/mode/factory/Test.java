package org.xigua.study.mode.factory;

import org.xigua.study.mode.factory.ingredient.ZJGPizzaIngredientFactory;
import org.xigua.study.mode.factory.pizza.Pizza;
import org.xigua.study.mode.factory.store.PizzaStore;
import org.xigua.study.mode.factory.store.ZJGPizzaStore;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class Test {
    public static void main(String[] args) {


        PizzaStore store1 = new ZJGPizzaStore(new ZJGPizzaIngredientFactory());
        Pizza pizza = store1.orderPizza("clam");
        System.out.println(pizza.toString());

    }
}
