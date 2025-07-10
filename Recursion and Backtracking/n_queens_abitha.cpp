// Problem Link :  https://leetcode.com/problems/n-queens/description/

class Solution {
public:
    // bool isSafe(int row, int col, vector<string> board, int n) {
    //     //just checking left will be fine

    //     //checking updiagonal
    //     int diagRow = row;
    //     int diagCol = col;
    //     while(diagRow >= 0 && diagCol >= 0) {
    //         if(board[diagRow][diagCol] == 'Q') {
    //             return false;
    //         }
    //         diagRow--;
    //         diagCol--;
    //     }

    //     //checking straight
    //     int stRow = row;
    //     int stCol = col;
    //     while(stCol >= 0) {
    //         if(board[stRow][stCol] == 'Q') {
    //             return false;
    //         }
    //         stCol--;
    //     }

    //     //checking downdiagonal
    //     diagRow = row;
    //     diagCol = col;
    //     while(diagRow < n && col >= 0) {
    //         if(board[diagRow][diagCol] == 'Q') {
    //             return false;
    //         }
    //         diagRow++;
    //         diagCol--;
    //     }

    //     return true;

        

    // }
    void solve(int col, vector<string>& board, vector<vector<string>>& ans, vector<int>& leftRow,vector<int>& upperDiagonal,vector<int>& lowerDiagonal, int n) {
        if(col == n) {
            ans.push_back(board);
            return;
        }
        for(int row = 0; row < n;row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row] = 1;
                solve(col+1, board, ans, leftRow, upperDiagonal, lowerDiagonal,n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
        // for(int row = 0; row < n;row++) {
        //     if(isSafe(row, col, board, n)) {
        //         board[row][col] = 'Q';
        //         solve(col+1, board, ans, n);
        //         board[row][col] = '.';
        //     }
        // }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string> board(n);
        string s(n,'.');
        for(int i = 0;i < n;i++) {
            board[i] = s;
        }

        vector<int> leftRow(n, 0), upperDiagonal(2*n-1, 0) , lowerDiagonal(2*n-1,0);

        solve(0, board, res, leftRow, upperDiagonal, lowerDiagonal, n);
        return res;
    }
};
