package org.yqj.source.demo.basic.classloader;

import java.util.Date;

public class MyDate extends Date{
    @Override
    public String toString() {
        return "this is my local date";
    }
}
