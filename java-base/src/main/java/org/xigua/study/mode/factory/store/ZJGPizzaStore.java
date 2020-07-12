package org.xigua.study.mode.factory.store;

import org.springframework.beans.factory.InitializingBean;
import org.xigua.study.mode.factory.ingredient.PizzaIngredientFactory;
import org.xigua.study.mode.factory.pizza.Pizza;
import org.xigua.study.mode.factory.pizza.ZJGCheesePizza;
import org.xigua.study.mode.factory.pizza.ZJGClamPizza;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public class ZJGPizzaStore extends PizzaStore implements InitializingBean {


    PizzaIngredientFactory factory;

    public ZJGPizzaStore(PizzaIngredientFactory factory) {
        this.factory = factory;
    }


    @Override
    protected Pizza createPizza(String type) {
        if ("clam".equals(type)) {
            return new ZJGClamPizza(factory);
        } else {
            return new ZJGCheesePizza(factory);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
