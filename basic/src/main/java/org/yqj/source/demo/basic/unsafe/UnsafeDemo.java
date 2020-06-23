package org.yqj.source.demo.basic.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * @author yaoqijun on 2017-11-09.
 */
public class UnsafeDemo {

    public static void main(String[] args) throws Exception{
        System.out.println("current unsafe demo");

//        Cat cat = new Cat("1", 12, "1", 1);
//        Object o = shallowCopy(cat);
//        System.out.println(cat.toString());
//        System.out.println(o.toString());

//        System.out.println(sizeOf(new Cat("animalName", 12, "catName", 12), unsafe));

//        memoryRead(unsafe);

//        memoryOccupy(unsafe);

//        instanceDemo(unsafe);
    }

    /**
     * 通过CAS 避免加锁方式
     */
    class CASCounter {
        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        public CASCounter() throws Exception {
            unsafe = unsafeBuild();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long before = counter;
            // 通过轮询 CAS 方式
            while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
                before = counter;
            }
        }

        public long getCounter() {
            return counter;
        }
    }

    static Object shallowCopy(Object obj) throws Exception {
        long size = sizeOf(obj);
        long start = toAddress(obj);
        long address = unsafeBuild().allocateMemory(size);
        unsafeBuild().copyMemory(start, address, size);
        return fromAddress(address);
    }

    static long toAddress(Object obj) throws Exception{
        Object[] array = new Object[] {obj};
        long baseOffset = unsafeBuild().arrayBaseOffset(Object[].class);
        return normalize(unsafeBuild().getInt(array, baseOffset));
    }

    static Object fromAddress(long address) throws Exception {
        Object[] array = new Object[] {null};
        long baseOffset = unsafeBuild().arrayBaseOffset(Object[].class);
        unsafeBuild().putLong(array, baseOffset, address);
        return array[0];
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }

    private static long sizeOf(Object o) throws Exception{
        HashSet<Field> fields = new HashSet<>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = unsafeBuild().objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize/8) + 1) * 8;   // padding
    }

    private static void memoryRead(Unsafe unsafe) throws Exception{
        Guard guard = new Guard();
        Field fieldFirst = Guard.class.getDeclaredField("first");
        long offsetFirst = unsafe.objectFieldOffset(fieldFirst);

        int value = unsafe.getInt(guard, offsetFirst);
        System.out.println("value : " + value);

        guard.setFirst(100);
        value = unsafe.getInt(guard, offsetFirst);
        System.out.println("value : " + value);
    }

    private static void memoryOccupy(Unsafe unsafe) throws Exception{
        Guard guard = new Guard();
        System.out.println(guard.giveAccess());


        Field fieldFirst = Guard.class.getDeclaredField("first");
        Field fieldSecond = Guard.class.getDeclaredField("second");
        Field fieldThird = Guard.class.getDeclaredField("third");
        long offsetFirst = unsafe.objectFieldOffset(fieldFirst);
        long offsetSecond = unsafe.objectFieldOffset(fieldSecond);
        long offsetThird = unsafe.objectFieldOffset(fieldThird);

        System.out.println("first : " + offsetFirst + " second: " + offsetSecond + " third: " + offsetThird);

//        unsafe.putInt(guard, offset, 42);
//        System.out.println("offset bit is " + offset);
//        System.out.println(guard.giveAccess());

        unsafe.putInt(guard, offsetFirst, 42);
        unsafe.putInt(guard, offsetFirst + 4, 42);
        unsafe.putInt(guard, offsetFirst + 8, 42);
        System.out.println(guard.getFirst());
        System.out.println(guard.getSecond());
        System.out.println(guard.getThird());
    }

    private static void instanceDemo(Unsafe unsafe) throws Exception{
        A a1 = new A();
        System.out.println(a1.a());

        A a2 = A.class.newInstance();
        System.out.println(a2.a());

        A a3 = (A) unsafe.allocateInstance(A.class);
        System.out.println(a3.a()); // not execute construct

//        B b1 = B.class.newInstance();
//        System.out.println(b1.b());

        B b = (B) unsafe.allocateInstance(B.class);
        System.out.println(b.b());
    }

    private static Unsafe unsafeBuild() throws Exception{
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
//        System.out.println(unsafe);
        return unsafe;
    }
}
