package org.yqj.source.demo.lettuce;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }

        int ct = l1.val + l2.val;
        ListNode result = new ListNode(ct % 10);
        ct = ct / 10;

        l1 = l1.next;
        l2 = l2.next;
        ListNode cur = result;


        while (l1 != null || l2 != null) {
            if (l1 != null) {
                ct += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                ct += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(ct % 10);
            cur = cur.next;
            ct = ct / 10;
        }

        if (ct > 0) {
            cur.next = new ListNode(1);
        }

        return result;
    }

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
