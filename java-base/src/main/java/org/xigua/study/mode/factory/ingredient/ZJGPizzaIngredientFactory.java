package org.xigua.study.mode.factory.ingredient;

import org.xigua.study.mode.factory.ingredient.cheese.Cheese;
import org.xigua.study.mode.factory.ingredient.cheese.ZJGCheeseImpl;
import org.xigua.study.mode.factory.ingredient.clams.Clams;
import org.xigua.study.mode.factory.ingredient.clams.ZJGClamsImpl;
import org.xigua.study.mode.factory.ingredient.dough.Dough;
import org.xigua.study.mode.factory.ingredient.dough.ZJGDoughImpl;
import org.xigua.study.mode.factory.ingredient.pepperoni.Pepperoni;
import org.xigua.study.mode.factory.ingredient.pepperoni.ZJGPepperoniImpl;
import org.xigua.study.mode.factory.ingredient.sauce.Sauce;
import org.xigua.study.mode.factory.ingredient.sauce.ZJGSauceImpl;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class ZJGPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Dough createDough() {
        return new ZJGDoughImpl();
    }

    @Override
    public Sauce createSauce() {
        return new ZJGSauceImpl();
    }

    @Override
    public Cheese createCheese() {
        return new ZJGCheeseImpl();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new ZJGPepperoniImpl();
    }

    @Override
    public Clams createClams() {
        return new ZJGClamsImpl();
    }
}
