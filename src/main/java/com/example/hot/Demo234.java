package com.example.hot;

public class Demo234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode half = half(head);
        ListNode reserve = reserve(half.next);
        ListNode a = head;
        ListNode b = reserve;
        boolean result = true;
        while (result && b != null) {
            if (a.val != b.val) {
                result = false;
            }

            a = a.next;
            b = b.next;
        }
        half.next = reserve(reserve);
        return result;

    }


    public ListNode reserve(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;

        }
        return pre;
    }

    public ListNode half(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
