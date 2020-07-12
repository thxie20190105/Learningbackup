package org.xigua.study.mode.factory2.readerfactoryimpl;

import org.xigua.study.mode.factory2.Reader;
import org.xigua.study.mode.factory2.ReaderFactory;
import org.xigua.study.mode.factory2.readerimpl.JpgReaderImpl;

/**
 * @author xigua
 * @description
 * @date 2020/5/13
 **/
public class JpgReaderFactoryImpl implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReaderImpl();
    }
}
