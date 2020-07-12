package org.xigua.study.javabase.proxy;

/**
 * @author org.xigua
 */
public interface ICook {
    /**
     * 检查食材
     */
    void dealWithFood();

    /**
     * 开始做菜
     *
     * @param name 做菜人
     * @return
     */
    int cook(String name);
}
