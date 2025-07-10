// Problem Link : https://leetcode.com/problems/sudoku-solver/


class Solution {
public:
    bool solve(vector<vector<char>>& board) {
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9';c++) {
                        if(checkValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board) == true) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    bool checkValid(vector<vector<char>>& board, int i, int j, char c) {
        for(int k = 0; k < 9;k++) {
            if(board[i][k] == c) {
                return false;
            }
            if(board[k][j] == c) {
                return false;
            }
            int startRow = 3 * (i / 3);
            int startCol = 3 * (j / 3);
            int boxRow = startRow + k / 3;
            int boxCol = startCol + k % 3;
            if(board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
};
