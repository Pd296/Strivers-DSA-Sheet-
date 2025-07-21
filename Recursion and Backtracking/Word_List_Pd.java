/*

Date : 19th July 2025
Problem Link : https://leetcode.com/problems/word-search/

*/

class Solution {

    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int charPosition) {
        
        //reached the end of the word
        if (charPosition == word.length())
            return true;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(charPosition) || board[i][j] == '#')
            return false;

        char temp = board[i][j];
        board[i][j] = '#';

        //traverse all directions
        boolean down = dfs(i + 1, j, board, word, charPosition + 1);
        boolean up = dfs(i - 1, j, board, word, charPosition + 1);
        boolean right = dfs(i, j + 1, board, word, charPosition + 1);
        boolean left = dfs(i, j - 1, board, word, charPosition + 1);
        board[i][j] = temp;
        
        return down || up || right || left;

    }
}