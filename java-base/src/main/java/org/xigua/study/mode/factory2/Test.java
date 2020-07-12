package org.xigua.study.mode.factory2;

import org.xigua.study.mode.factory2.readerfactoryimpl.JpgReaderFactoryImpl;
import org.xigua.study.mode.factory2.readerfactoryimpl.PngReaderFactoryImpl;

/**
 * @author xigua
 * @description 工厂方法模式
 * @date 2020/5/13
 **/
public class Test {
    public static void main(String[] args) {


        //针对不同的对象，提供不同的工厂。
        Reader jpgReader = new JpgReaderFactoryImpl().getReader();
        Reader pngReader = new PngReaderFactoryImpl().getReader();

        jpgReader.read();
        pngReader.read();

    }

}
