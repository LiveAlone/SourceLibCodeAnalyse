package org.yqj.source.tool.basic.base;

/**
 * @author yaoqijun on 2017-11-10.
 */
public class FinallyDemo {
    public static void main(String[] args) {
        try {
            System.exit(1);
        } finally {
            System.out.println("I'm here, man");
        }
    }
}
