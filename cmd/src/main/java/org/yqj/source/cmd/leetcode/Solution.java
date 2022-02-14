package org.yqj.source.cmd.leetcode;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/10/27
 * Email: yaoqijunmail@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        for (int pos = 0; pos < nums.length; pos++) {
            if (pos != 0) {
                nums[pos] += nums[pos -1];
            }

            if (nums[pos] == k) {
                sum += 1;
            }

            for (int i = 0; i < pos; i++) {
                if (nums[pos] - nums[i] == k) {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}
