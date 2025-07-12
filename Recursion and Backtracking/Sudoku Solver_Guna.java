
//date- 11_jul_2025
//link-https://leetcode.com/problems/sudoku-solver/description/

class Solution {
    boolean is_valid(char[][] board,char num,int row,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;

            if(board[i][col]==num) return false;

        }
        int in_mat_row=3 * (row/3);
        int in_mat_col=3 * (col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[in_mat_row+i][in_mat_col+j]==num) return false;
            }
        }
        return true;
    }
    boolean solve(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char i='1';i<='9';i++){
                        if(is_valid(board,i,row,col)){
                            board[row][col]=i;
                            if(solve(board)) return true;
                             else board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        boolean d=solve(board);
        return;
    }
}