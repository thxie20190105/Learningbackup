package org.xigua.study.mode.factory2.readerimpl;

import org.xigua.study.mode.factory2.Reader;

/**
 * @author xigua
 * @description
 * @date 2020/5/13
 **/
public class JpgReaderImpl implements Reader {
    @Override
    public void read() {
        System.out.println("this is jpg");
    }
}
