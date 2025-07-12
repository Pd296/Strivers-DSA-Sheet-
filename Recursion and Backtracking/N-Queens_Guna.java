
//date-10-jul
//https://leetcode.com/problems/n-queens/description/

class Solution {
    /*void block_matrix(int[][] mat,int row,int col,boolean block){
        int n=mat.length;
        for(int c=0;c<n;c++){
            if(c==col) continue;
            if(block) mat[row][c]++;
            else mat[row][c]--;
        }
        
        for(int r=0;r<n;r++){
            if(r==row) continue;
            if(block) mat[r][col]++;
            else mat[r][col]--;
        }
        for(int r=col-1;r>=0;r--){
            if(block) mat[r][col]++;
            else mat[r][col]--;
        }
        return ;

    }  */
    void helper(char[][] mat,int row,int[] col_check,int[] left_diag, int[] right_diag,List<List<String>> ans){
        int n=mat.length;
        if(row>=mat.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                String s=String.valueOf(mat[i]);
                temp.add(s);
            }
            ans.add(temp);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(col_check[i]==0 && left_diag[mat.length-1-row+i]==0 && right_diag[i+row]==0){
                col_check[i]=1;
                left_diag[n-1-row+i]=1;
                right_diag[i+row]=1;
                mat[row][i]='Q';
                helper(mat,row+1,col_check,left_diag,right_diag,ans);
                mat[row][i]='.';
                col_check[i]=0;
                left_diag[n-1-row+i]=0;
                right_diag[i+row]=0;

            }
        }
        return;
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] mat=new char[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mat[i][j]='.';
            }
        }
        int[] col_check=new int[n];
        int[] left_diag=new int[2*n-1];
        int[] right_diag=new int[2*n-1];
        List<List<String>> ans=new ArrayList<>();
        helper(mat,0,col_check,left_diag,right_diag,ans);
        return ans;
    }
}