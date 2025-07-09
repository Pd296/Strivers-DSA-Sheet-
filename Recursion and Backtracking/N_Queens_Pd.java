/*

Date : 9th July 2025
Problem Link : https://leetcode.com/problems/n-queens/

 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 1) new ArrayList<>(Arrays.asList("Q"));
 
        //initialize the board 
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        recurse(result,board,n,0);
        return result;
    }

    private void recurse( List<List<String>> result,char[][] board,int n,int row){

        if(row >= n) {
            result.add(build(board));
            return;
        };

        for(int col=0;col<n;col++){
            if(canPlaceQueen(board,row,col,n)){
                   board[row][col]='Q';
                   recurse(result,board,n,row+1);
                    board[row][col]='.';
            } 

        }
    }
    private boolean canPlaceQueen(char[][] board,int r,int c,int n){

        //check the row
        for(int i=0;i<r;i++){
            if(board[i][c] == 'Q') return false;
        }

        //check the 45 degree angle
        for(int i=r-1,j=c+1;i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        
        //check the 135 degree angle
         for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> build(char[][] board){
        List<String> string = new ArrayList<>();
        for(int i=0;i<board.length;i++){
                string.add(new String(board[i]));
        }
        return string;
    }
}