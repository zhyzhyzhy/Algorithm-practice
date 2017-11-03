/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/29 - 11:36:46
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.equals("")) {
            return false;
        }
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = ' ';
                    if (exist(board, word, 1, i, j)) {
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word, int index,int i, int j) {
        if (index > word.length() - 1) {
            return true;
        }
        if (j + 1 < board[i].length && board[i][j+1] == word.charAt(index)) {
            board[i][j+1] = ' ';
            if (exist(board, word, index + 1, i, j + 1)) {    
                return true;
            }
            board[i][j+1] = word.charAt(index);
            
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index)) {
            board[i][j-1] = ' ';
            if (exist(board, word, index + 1, i, j - 1)) {
                return true;
            }
            board[i][j-1] = word.charAt(index);
        }
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(index)) {
            board[i+1][j] = ' ';
            if (exist(board, word, index + 1, i+1, j)) {
                return true;
            }
            board[i+1][j] = word.charAt(index);
        }
        if (i - 1 >= 0 && board[i-1][j] == word.charAt(index)) {
            board[i-1][j] = ' ';
            if (exist(board, word, index + 1, i - 1, j)) {
                return true;
            }
            board[i-1][j] = word.charAt(index);
        }
        return false;
    }
}
