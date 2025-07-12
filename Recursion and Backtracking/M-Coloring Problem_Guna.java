
//date-12-jul-2025
//link-https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

class Solution {
    boolean is_valid(int[][] edges,int node,int[] c_map,int col){
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==node){
                if(c_map[edges[i][1]]==col) return false;
            }
            else if(edges[i][1]==node){
                if(c_map[edges[i][0]]==col) return false;
            }
        }
        return true;
    }
    
    boolean color(int[][] edges,int node,int v,int m,int[] c_map){
        if(node==v) return true;
        for(int col=1;col<=m;col++){
            if(is_valid(edges,node,c_map,col)){
                c_map[node]=col;
                boolean temp=color(edges,node+1,v,m,c_map);
                if(temp) return true;
                c_map[node]=0;
            }
        }
        return false;
    }
    
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] c_map=new int[v];
       return color(edges,0,v,m,c_map);
    }
}