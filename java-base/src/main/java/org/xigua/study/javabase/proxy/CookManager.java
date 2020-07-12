package org.xigua.study.javabase.proxy;

/**
 * @author org.xigua
 */
public class CookManager implements ICook {


    @Override
    public void dealWithFood() {
        System.out.println("food had been dealed with");
    }

    @Override
    public int cook(String name) {
        System.out.println(name + "cook food");
        return 0;
    }
}
