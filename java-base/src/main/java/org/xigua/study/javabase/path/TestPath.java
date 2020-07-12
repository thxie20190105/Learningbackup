package org.xigua.study.javabase.path;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @author xigua
 */
public class TestPath {
    public static void main(String[] args) throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);

    }
}
