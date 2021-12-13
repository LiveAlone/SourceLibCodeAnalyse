package org.yqj.source.tool.basic.steam;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: basic steam
 *
 * @author yaoqijun
 * @date 2021/12/13
 * Email: yaoqijunmail@foxmail.com
 */
public class SteamBasicMain {

    public static void main(String[] args) {
        System.out.println("steam main test config");

        List<String> result = Lists.newArrayList(1, 2, 3, 4).stream()
                .map(s -> s * 10)
                .flatMap(p -> Stream.of(p, p / 2, p / 4, p / 8))
                .map(String::valueOf).collect(Collectors.toList());
    }
}
