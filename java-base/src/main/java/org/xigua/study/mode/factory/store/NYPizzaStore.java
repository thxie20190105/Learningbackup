package org.xigua.study.mode.factory.store;

import org.xigua.study.mode.factory.ingredient.PizzaIngredientFactory;
import org.xigua.study.mode.factory.pizza.NYCheesePizza;
import org.xigua.study.mode.factory.pizza.NYClamPizza;
import org.xigua.study.mode.factory.pizza.Pizza;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class NYPizzaStore extends PizzaStore {

    private PizzaIngredientFactory factory;

    public NYPizzaStore(PizzaIngredientFactory factory) {
        this.factory = factory;
    }


    @Override
    protected Pizza createPizza(String type) {
        if ("clam".equals(type)) {
            return new NYClamPizza(factory);
        } else {
            return new NYCheesePizza(factory);
        }
    }
}
