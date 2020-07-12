package org.xigua.study.mode.factory.ingredient;

import org.xigua.study.mode.factory.ingredient.cheese.Cheese;
import org.xigua.study.mode.factory.ingredient.clams.Clams;
import org.xigua.study.mode.factory.ingredient.dough.Dough;
import org.xigua.study.mode.factory.ingredient.pepperoni.Pepperoni;
import org.xigua.study.mode.factory.ingredient.sauce.Sauce;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public interface PizzaIngredientFactory {

    /**
     * @return 面粉
     */
    Dough createDough();

    /**
     * @return 酱
     */
    Sauce createSauce();

    /**
     * @return 起司
     */
    Cheese createCheese();

    /**
     * @return 意大利香肠
     */
    Pepperoni createPepperoni();

    /**
     * @return 蛤蜊
     */
    Clams createClams();

}
