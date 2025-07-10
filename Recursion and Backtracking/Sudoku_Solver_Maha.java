class Solution {
    public void solveSudoku(char[][] board) {
        boolean ans = solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(canPlace(i,j,board,ch)){
                            board[i][j]=ch;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canPlace(int row,int col,char[][] board,int num){
        for(int i=0;i<9;i++){ 
            if(board[row][i]==num) return false;
            if(board[i][col]==num) return false;
        }
        int boxRowStart=(row/3)*3;
        int boxColStart=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[boxRowStart+i][boxColStart+j]==num) return false;
            }
        }
        return true;
    }
}