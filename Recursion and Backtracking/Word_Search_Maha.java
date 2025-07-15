class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==word.charAt(0)){
                    if(dfs(row, col, 0, board, word, visited)) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int row,int col,int index,char[][] board,String word,boolean[][] visited){
        if(index==word.length()) return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length) return false;
        if(board[row][col] != word.charAt(index)) return false;
        if(visited[row][col]) return false;
        visited[row][col] = true;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        for(int d=0;d<4;d++){
            int r=row+x[d];
            int c=col+y[d];
            if (dfs(r,c,index + 1,board,word,visited)) return true;
        }
        visited[row][col] = false; 
        return false;
    }
}