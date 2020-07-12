package org.xigua.study.mode.factory.pizza;

import org.xigua.study.mode.factory.ingredient.cheese.Cheese;
import org.xigua.study.mode.factory.ingredient.clams.Clams;
import org.xigua.study.mode.factory.ingredient.dough.Dough;
import org.xigua.study.mode.factory.ingredient.pepperoni.Pepperoni;
import org.xigua.study.mode.factory.ingredient.sauce.Sauce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/5/11
 **/
public abstract class Pizza {
    /**
     * 披萨名称
     */
    String name;
    /**
     * 使用的面粉
     */
    Dough dough;
    /**
     * 酱料
     */
    Sauce sauce;

    /**
     * 起司
     */
    Cheese cheese;

    /**
     * 蛤蜊
     */
    Clams clams;

    /**
     * 意大利香肠
     */
    Pepperoni pepperoni;


    /**
     * 佐料
     */
    List list = new ArrayList();


    /**
     * 准备
     */
    public abstract void prepare();


    public void bake() {
        System.out.println("bake");
    }

    public void cut() {
        System.out.println("cut");
    }

    public void box() {
        System.out.println("box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", clams=" + clams +
                ", pepperoni=" + pepperoni +
                ", list=" + list +
                '}';
    }
}
