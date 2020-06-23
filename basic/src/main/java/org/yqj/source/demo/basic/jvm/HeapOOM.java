package org.yqj.source.demo.basic.jvm;

/**
 * Created by yaoqijun on 2017/6/28.
 */
public class HeapOOM {
    public static void main(String[] args) {
//        List<OOMObject> oomObjects = new ArrayList<>();
//        while (true){
//            oomObjects.add(new OOMObject());
//        }
        String str1 = "1234";
        String str2 = "1234";
        System.out.println(str1.intern() == str2.intern());
    }

    public static class OOMObject{}
}
