package com.example.hot;

public class Demo208 {

    class Trie {
        private Trie[] child;
        private boolean idEnd;

        public Trie() {
            child = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new Trie();
                }
                node = node.child[index];
            }
            node.idEnd = true;

        }

        public boolean search(String word) {

            Trie trie = searchPrefix(word);
            return trie != null && trie.idEnd;

        }

        public boolean startsWith(String prefix) {
            Trie trie = searchPrefix(prefix);
            return trie != null;

        }

        public Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    return null;
                }

                node = node.child[index];
            }

            return node;
        }
    }
}

