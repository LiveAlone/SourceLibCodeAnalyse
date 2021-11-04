package org.yqj.source.demo.lettuce;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/11/4
 * Email: yaoqijunmail@foxmail.com
 */
public class ByteUtil {

    public static final byte pos1 = (byte) 0x80;
    public static final byte pos2 = (byte) 0x40;
    public static final byte pos3 = (byte) 0x20;
    public static final byte pos4 = (byte) 0x10;

    public static final byte pos5 = (byte) 0x08;
    public static final byte pos6 = (byte) 0x04;
    public static final byte pos7 = (byte) 0x02;
    public static final byte pos8 = (byte) 0x01;

    public static List<Integer> listPost(byte[] arr) {
        if (arr == null || arr.length == 0){
            return Collections.emptyList();
        }
        List<Integer> result = Lists.newArrayList();
        for (int i = 0; i < arr.length; i++) {
            byte cur = arr[i];
            int basic = i * 8;
            if ((cur & pos1) == pos1) result.add(basic + 1);
            if ((cur & pos2) == pos2) result.add(basic + 2);
            if ((cur & pos3) == pos3) result.add(basic + 3);
            if ((cur & pos4) == pos4) result.add(basic + 4);
            if ((cur & pos5) == pos5) result.add(basic + 5);
            if ((cur & pos6) == pos6) result.add(basic + 6);
            if ((cur & pos7) == pos7) result.add(basic + 7);
            if ((cur & pos8) == pos8) result.add(basic + 8);
        }
        return result;
    }

}
