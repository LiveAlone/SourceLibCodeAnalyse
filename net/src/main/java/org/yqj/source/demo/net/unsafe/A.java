package org.yqj.source.demo.net.unsafe;

/**
 * @author yaoqijun on 2017-11-09.
 */
public class A {
    private long a; // not initialized value

    public A() {
        this.a = 1; // initialization
    }

    public long a() { return this.a; }
}
