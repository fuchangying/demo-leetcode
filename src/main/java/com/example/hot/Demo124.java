package com.example.hot;

public class Demo124 {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int value = left + right + node.val;

        maxValue = Math.max(maxValue, value);
        return Math.max(left, right) + node.val;
    }

    private class TreeNode {
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
}
