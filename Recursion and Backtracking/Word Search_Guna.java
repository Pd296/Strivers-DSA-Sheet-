
//date-12-jul-2025
//link-https://leetcode.com/problems/word-search/description/

class Solution {
    boolean find(char[][] board,String word,int i,int row,int col){
        if(i==word.length())return true;
        if(board[row][col]=='.') return false;
        char c=board[row][col];
        board[row][col]='.';
        //up
        if(row-1>=0 && board[row-1][col]==word.charAt(i)) {
            if(find(board,word,i+1,row-1,col)) return true;
        }
        //right
        if(col+1<board[0].length && board[row][col+1]==word.charAt(i)) {
            if(find(board,word,i+1,row,col+1)) return true;
        }
        //down
        if(row+1<board.length && board[row+1][col]==word.charAt(i)) {
            if(find(board,word,i+1,row+1,col)) return true;
        }
        //left
        if(col-1>=0 && board[row][col-1]==word.charAt(i)) {
            if(find(board,word,i+1,row,col-1)) return true;
        }
        board[row][col]=c;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(find(board,word,1,i,j)) return true;
                }
            }
        }
        return false;
    }
}