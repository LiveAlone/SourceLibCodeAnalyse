package org.yqj.source.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/5/21
 * Email: yaoqijunmail@foxmail.com
 */
public class Solution {

    public int max(String s) {
        int max = 0;
        if(s.length() == 0) {
            return 0;
        }

        int maxPosFrom = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0){
                max = 1;
                continue;
            }
            Character current = s.charAt(i);
            for (int j = i - 1; j >= maxPosFrom; j--) {
                if(current.equals(s.charAt(j))){
                    maxPosFrom = j + 1;
                    break;
                }
            }

            if(i - maxPosFrom + 1 > max) {
                max = i - maxPosFrom + 1;
            }
        }
        return max;
    }
}
