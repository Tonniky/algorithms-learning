package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode212 {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {};
    }

    char[][] _board = null;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode node = trie;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter))
                    node = node.children.get(letter);
                else {
                    TrieNode newTrie = new TrieNode();
                    node.children.put(letter, newTrie);
                }
            }
            node.word = word;
        }
        this._board = board;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (trie.children.containsKey(board[row][col])) {
                    backTrack(row, col, trie);
                }
            }
        }
        return this.result;
    }

    private void backTrack(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);
        if (currNode != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }

        this._board[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < colOffset.length; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0 ||
            newCol >= this._board.length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol]))
                backTrack(newRow, newCol, currNode);
        }
        this._board[row][col] = letter;
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    }

