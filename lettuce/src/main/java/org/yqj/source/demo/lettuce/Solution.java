package org.yqj.source.demo.lettuce;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> valuesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = valuesMap.get(target - nums[i]);
            if (pos != null) {
                result[0] = pos;
                result[1] = i;
                return result;
            }
            valuesMap.put(nums[i], i);
        }
        return result;
    }
}
