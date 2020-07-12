package org.xigua.study.mode.factory.ingredient;

import org.xigua.study.mode.factory.ingredient.cheese.Cheese;
import org.xigua.study.mode.factory.ingredient.cheese.NYCheeseImpl;
import org.xigua.study.mode.factory.ingredient.clams.Clams;
import org.xigua.study.mode.factory.ingredient.clams.NYClamsImpl;
import org.xigua.study.mode.factory.ingredient.dough.Dough;
import org.xigua.study.mode.factory.ingredient.dough.NYDoughImpl;
import org.xigua.study.mode.factory.ingredient.pepperoni.NYPepperoniImpl;
import org.xigua.study.mode.factory.ingredient.pepperoni.Pepperoni;
import org.xigua.study.mode.factory.ingredient.sauce.NYSauceImpl;
import org.xigua.study.mode.factory.ingredient.sauce.Sauce;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new NYDoughImpl();
    }

    @Override
    public Sauce createSauce() {
        return new NYSauceImpl();
    }

    @Override
    public Cheese createCheese() {
        return new NYCheeseImpl();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new NYPepperoniImpl();
    }

    @Override
    public Clams createClams() {
        return new NYClamsImpl();
    }
}
