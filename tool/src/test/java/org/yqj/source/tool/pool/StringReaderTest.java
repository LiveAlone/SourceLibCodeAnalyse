package org.yqj.source.tool.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/8/12
 * Email: yaoqijunmail@foxmail.com
 */
public class StringReaderTest {

    @Test
    public void basicTest() {
        ReaderUtil readerUtil = new ReaderUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
        Reader reader = new StringReader("foo");
        try {
            System.out.println(readerUtil.readToString(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
