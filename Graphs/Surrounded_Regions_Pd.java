/*

  Problem Link : https://leetcode.com/problems/surrounded-regions/
  Date : 26th August 2025

 */

class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        //traverse left and right borders and mark connected 'O's . These 'O's are not surrounded
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O') dfs(board,i,0);
            if(board[i][n-1] == 'O') dfs(board,i,n-1);
        }

        //traverse top and bottom borders and mark connected 'O'. These 'O's are not surrounded
        for(int j=0;j<n;j++){
            if(board[0][j] == 'O') dfs(board,0,j);
            if(board[m-1][j] == 'O') dfs(board,m-1,j);
        }

        //Surround everything except the marked 'V's . All other O's will be surrounded
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(board[i][j]=='O') board[i][j]='X';
                 if(board[i][j]=='V') board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board,int i,int j){
        int m = board.length;
        int n = board[0].length; 

        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='X' || board[i][j]=='V') return;

        //mark visited
        board[i][j]='V';

        //traverse 4 directions
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }
}