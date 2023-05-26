package org.yqj.source.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2023/5/24
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class TestLeetCode {

    @Test
    public void testSolution(){
        Solution s = new Solution();
        log.info("test 1 {}", s.reverse(-2147483648));

    }
}
