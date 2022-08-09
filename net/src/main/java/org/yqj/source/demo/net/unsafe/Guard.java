package org.yqj.source.demo.net.unsafe;

/**
 * @author yaoqijun on 2017-11-09.
 */
public class Guard {

    private int first = 1;

    private int second = 1;

    private int third = 1;

    public boolean giveAccess(){
        return first == 42;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }
}
