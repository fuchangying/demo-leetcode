package com.example.hot;

import java.util.HashMap;
import java.util.Map;

public class Demo146 {


    class LRUCache {

        private int size;
        private int capacity;
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private DLinkedNode head;
        private DLinkedNode tail;

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;

            public DLinkedNode(int _key, int _value) {
                this.key = _key;
                this.value = _value;
            }

            public DLinkedNode() {

            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;


        }

        public int get(int key) {
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode == null) {
                return -1;
            }
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode dLinkedNode = new DLinkedNode(key, value);
                cache.put(key, dLinkedNode);
                addToHead(dLinkedNode);
                size++;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);

            }

        }

        public void addToHead(DLinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void deleteNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void moveToHead(DLinkedNode node) {
            deleteNode(node);
            addToHead(node);
        }

        public DLinkedNode removeTail() {
            DLinkedNode pre = tail.pre;
            deleteNode(pre);
            return pre;
        }
    }

}
