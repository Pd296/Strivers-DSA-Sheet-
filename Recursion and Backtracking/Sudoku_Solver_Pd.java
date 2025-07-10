/*

Date : 10th July 2025
Problem Link : https://leetcode.com/problems/sudoku-solver/

 */

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                char currentCharacter = board[i][j];
                if(currentCharacter != '.') continue ;

                for(char k='1';k<='9';k++){

                    if(canPlace(board,i,j,k)){
                        board[i][j]=k;
                        if(solve(board)) return true;
                        else board[i][j]='.';
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean canPlace(char[][] board,int row,int col,int number){

        for(int i=0;i<9;i++){

            if(board[row][i] == number) return false; // check the column
            if(board[i][col] == number) return false; // check the row

            //check the 3x3 box 
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            if(board[r][c] ==number) return false;
        }
        return true;
    }
}