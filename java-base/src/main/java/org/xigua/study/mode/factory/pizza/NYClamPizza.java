package org.xigua.study.mode.factory.pizza;

import org.xigua.study.mode.factory.ingredient.PizzaIngredientFactory;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class NYClamPizza extends Pizza {
    //加载原料工厂
    PizzaIngredientFactory factory;

    public NYClamPizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        clams = factory.createClams();
    }


}
