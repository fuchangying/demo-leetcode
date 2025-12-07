package com.example.hot;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/?envType=problem-list-v2&envId=t79LTxQN">合并两个有序链表</a>
 */
public class Demo21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode pre = new ListNode();
        ListNode ans=pre;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                pre.next = node2;
                node2 = node2.next;
            } else {
                pre.next = node1;
                node1 = node1.next;
            }

            pre = pre.next;
        }

        if (node1 != null) {
            pre.next = node1;
        }

        if (node2 != null) {
            pre.next = node2;
        }

        return ans.next;

    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
