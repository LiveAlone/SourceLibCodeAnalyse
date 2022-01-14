package org.yqj.source.demo.spring.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.core.ResolvableType;
import org.yqj.source.demo.spring.event.FruitBasicEventListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/14
 * Email: yaoqijunmail@foxmail.com
 */
public class ResolvableTypeTest {

    public static void main(String[] args) {
        ResolvableType NONE = ResolvableType.NONE;
//        System.out.println(resolveDeclaredEventType(FruitBasicEventListener.class, ApplicationListener.class));
//        List<Integer> ls = Lists.newArrayList(1, 2);
//        System.out.println(resolveDeclaredEventType(ls.getClass(), ArrayList.class));
//        System.out.println(resolveDeclaredEventType(LocalIntegerList.class, ArrayList.class));

//        localReflectAnalyse(FruitBasicEventListener.class);
//        localReflectAnalyse(ArrayList.class);
        localReflectAnalyse(LocalIntegerList.class);
    }

    static ResolvableType resolveDeclaredEventType(Class<?> listenerType, Class<?> asClass) {
        return ResolvableType.forClass(listenerType).as(ApplicationListener.class).getGeneric();
    }

    private static void localReflectAnalyse(Class<?> listener) {
        Type type = listener.getGenericInterfaces()[0];

        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                System.out.println(actualTypeArguments[i].getTypeName());
            }
        }
//
//        ResolvableType resolvableType = ResolvableType.forClass(listener);
//        ResolvableType interfaceResolveType = resolvableType.getInterfaces()[0];
//        for (ResolvableType generic : interfaceResolveType.getGenerics()) {
//            System.out.println(generic.toString());
//        }
    }

    public static class LocalIntegerList implements LocalList<Integer> {
    }

    public static interface LocalList<E>{}
}
