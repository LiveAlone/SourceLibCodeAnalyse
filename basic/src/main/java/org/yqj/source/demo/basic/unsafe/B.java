package org.yqj.source.demo.basic.unsafe;

/**
 * @author yaoqijun on 2017-11-09.
 */
public class B {
    private long b;

    private B(int x, int y){
        b = x + y;
    }

    public long b(){
        return b;
    }
}
