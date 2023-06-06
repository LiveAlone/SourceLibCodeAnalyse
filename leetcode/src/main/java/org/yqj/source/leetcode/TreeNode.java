package org.yqj.source.leetcode;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2023/6/4
 * Email: yaoqijunmail@foxmail.com
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
