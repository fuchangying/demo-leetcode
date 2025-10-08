package com.example.hot;


public class Demo160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }

        return a;

    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}