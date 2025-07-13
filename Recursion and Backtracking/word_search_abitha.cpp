Problem Link : https://leetcode.com/problems/word-search/
class Solution {
public:
    bool backtrack(int i, int j, vector<vector<char>>& board, int ind, string word) {
        if(ind == word.length()) {
            return true;
        }
        if(board[i][j] != word[ind]) {
            return false;
        }
        if(word.size() == 1) {
            return true;
        }
        
        //now i need to check if remaining is there
        char ch = board[i][j];
        board[i][j] = '.';
        //right side
        int row = i+0;
        int col = j+1;
        if(0 <= row && row < board.size() && 0 <= col && col < board[0].size()) {
            if(backtrack(row, col, board, ind+1, word)) {
                return true;
            }
        }
        //left side
        row = i;
        col = j-1;
        if(0 <= row && row < board.size() && 0 <= col && col < board[0].size()) {
            if(backtrack(row, col, board, ind+1, word)) {
                return true;
            }
        }
        //up
        row = i-1;
        col = j;
        if(0 <= row && row < board.size() && 0 <= col && col < board[0].size()) {
            if(backtrack(row, col, board, ind+1, word)) {
                return true;
            }
        }
        //down
        row = i+1;
        col = j;
        if(0 <= row && row < board.size() && 0 <= col && col < board[0].size()) {
            if(backtrack(row, col, board, ind+1, word)) {
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size();
        int col = board[0].size();
        for(int i = 0; i < row; i++) {
            for(int j = 0;j < col; j++) {
                if(backtrack(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
};
