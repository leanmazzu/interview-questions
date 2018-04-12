package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TrieNode {

    HashMap<Character, TrieNode> children = new HashMap<>();
    TrieNode parent;
    boolean isWord;
    String word;
    int count = 0;

    public void add(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            TrieNode tn;
            if (!current.children.containsKey(currentChar)) {
                tn = new TrieNode();
                tn.word = word.substring(0,i+1);
                current.children.put(currentChar, tn);
            } else {
                tn = current.children.get(currentChar);
            }
            tn.isWord = (i == word.length() - 1);
            tn.parent = current;
            tn.count++;
            current = tn;
        }
    }

    public boolean remove(String word) {
        TrieNode lastNode = find(word);
        if (lastNode!=null && lastNode.isWord) {
            if (lastNode.children.size()>0) {
                lastNode.isWord = false;
            } else {
                TrieNode parent = lastNode.parent;
                TrieNode current = lastNode;
                while (parent!=null && !current.isWord) {
                    parent.children.remove(current);
                    current = parent;
                    parent = parent.parent;
                }
            }

            TrieNode parent = lastNode;
            while (parent!=null) {
                parent.count--;
                parent = parent.parent;
            }
            return true;
        }

        return false;
    }

    public int getWordsCountStartingFromWord(String word) {
        TrieNode trieNode = find(word);
        if (trieNode!=null) {
            return trieNode.count;
        }
        return 0;
    }

    public ArrayList<String> findWords() {
        return findWords(new ArrayList<>());
    }

    private ArrayList<TrieNode> findWordNodes(ArrayList<TrieNode> current) {
        if (isWord) {
            current.add(this);
        }
        for (TrieNode children : this.children.values()) {
            children.findWordNodes(current);
        }
        return current;
    }

    private ArrayList<String> findWords(ArrayList<String> current) {
        if (isWord) {
            current.add(this.word);
        }
        for (TrieNode children : this.children.values()) {
            children.findWords(current);
        }
        return current;
    }

    public TrieNode find(String prefix) {
        TrieNode current = this;
        for (int i=0; i<prefix.length(); i++) {
            Character currentChar = prefix.charAt(i);
            if (!current.children.containsKey(currentChar)) {
                return null;
            }
            current = current.children.get(currentChar);
        }
        return current;
    }

    public int countWordsStartingFromNodeRecursive(TrieNode node, int count) {
        for (TrieNode tn : node.children.values()) {
            count += countWordsStartingFromNodeRecursive(tn, count);
        }

        if (node.isWord) {
            count++;
        }

        return count;
    }
}
