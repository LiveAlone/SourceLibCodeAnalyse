package org.yqj.source.demo.basic.net;

import java.net.URL;
import java.util.HashSet;

/**
 * @author yaoqijun on 2017-11-10.
 */
public class URLDemo {
    public static void main(String[] args) throws Exception {
        HashSet set = new HashSet();
        set.add(new URL("http://google.com"));
        System.out.println(set.contains(new URL("http://google.com")));
        Thread.sleep(60000);
        System.out.println(set.contains(new URL("http://google.com")));
    }
}
