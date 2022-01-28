package org.yqj.source.tool.asm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yqj.source.tool.aop.asm.Simple;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/27
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class SimpleTest {

    @Test
    public void sumTest() {
        log.info("sum result is :{}", Simple.sum());
    }
}
