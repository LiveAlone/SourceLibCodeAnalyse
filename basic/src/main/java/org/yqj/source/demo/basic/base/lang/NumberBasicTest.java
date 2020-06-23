package org.yqj.source.demo.basic.base.lang;

public class NumberBasicTest {
    public static void main(String[] args) {

//        System.out.println(Double.NaN);
//        System.out.println(Double.POSITIVE_INFINITY);
//        System.out.println(Double.NEGATIVE_INFINITY);
//        System.out.println(Double.MAX_EXPONENT);

        System.out.println(Byte.valueOf((byte)1) == Byte.valueOf((byte)1));
        System.out.println(Integer.valueOf(1) == Integer.valueOf(1));
        System.out.println(Short.valueOf((short) 1) == Short.valueOf((short) 1));
        System.out.println(Long.valueOf((long)1) == Long.valueOf((long) 1));
    }
}
