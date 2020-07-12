package org.xigua.study.mode.factory.pizza;

import org.xigua.study.mode.factory.ingredient.PizzaIngredientFactory;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class NYCheesePizza extends Pizza {

    PizzaIngredientFactory factory;

    public NYCheesePizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        clams = factory.createClams();
    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
