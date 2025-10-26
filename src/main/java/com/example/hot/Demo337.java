package com.example.hot;

import java.util.HashMap;

public class Demo337 {
    HashMap<TreeNode, Integer> check = new HashMap<>();
    HashMap<TreeNode, Integer> uncheck = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(check.getOrDefault(root, 0), uncheck.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        int checkNum = node.val + uncheck.getOrDefault(node.left, 0) + uncheck.getOrDefault(node.right, 0);
        check.put(node, checkNum);
        int uncheckNum = Math.max(check.getOrDefault(node.left, 0), uncheck.getOrDefault(node.left, 0)) +
                Math.max(check.getOrDefault(node.right, 0), uncheck.getOrDefault(node.right, 0));
        uncheck.put(node, uncheckNum);
    }


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
}
