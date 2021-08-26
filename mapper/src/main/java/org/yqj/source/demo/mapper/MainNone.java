package org.yqj.source.demo.mapper;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/26
 * Email: yaoqijunmail@foxmail.com
 */
public class MainNone {
    public static void main(String[] args) {
        Source source = new Source();
        source.setFoo(42);
        source.setBar(23L);
        source.setZip(73);

        Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);

        System.out.println(target);
    }
}
