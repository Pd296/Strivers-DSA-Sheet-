class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] x = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(x[i], '.');
        solve(0,x,ans,n);
        return ans;
    }
    public static void solve(int row,char[][] x,List<List<String>> ans,int n){
        if(row==n){
            List<String> y=new ArrayList<>();
            for(char[] c:x){
                y.add(new String(c));
            }
            ans.add(y);
            return;
        }
        for(int col=0;col<n;col++){
            if(canPlace(row,col,x,n)){
                x[row][col]='Q';
                solve(row+1,x,ans,n);
                x[row][col]='.';
            }
        }
    }
    public static boolean canPlace(int row,int col,char[][] x,int n){
        for(int i=0;i<row;i++){
            if(x[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(x[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(x[i][j]=='Q') return false;
        }
        return true;
    }
}