/*

   Problem Link : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
   Date : 8th October 2025

 */

// Using Disjoint Set (Union by Size and Path Compression)
class DisjointSet {
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    
    int findUParent(int node){
        
        if( node == parent[node]) return node;
        
        parent[node] = findUParent(parent[node]);
        return parent[node];
    }
    
    void unionBySize(int nodeU,int nodeV){
        
       int ultimateParent_U = findUParent(nodeU);
       int ultimateParent_V = findUParent(nodeV);
       
       if(ultimateParent_U == ultimateParent_V) return;
       
       if(size[ultimateParent_U] < size[ultimateParent_V]){
            parent[ultimateParent_U] = ultimateParent_V;
            size[ultimateParent_V] += size[ultimateParent_U];
       }else{
            parent[ultimateParent_V] = ultimateParent_U;
            size[ultimateParent_U] += size[ultimateParent_V];
       }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        
        int maxRow = 0;
        int maxCol = 0;
        int totalStones = 0;
        for(int[] arr : stones){
            int row = arr[0];
            int col = arr[1];
            maxRow = Math.max(row,maxRow);
            maxCol = Math.max(col,maxCol);
            totalStones += 1;
        }
        
        /*

        1) Consider all the nodes in each row/col as one entity
        2) indexes 0 to maxRow-1 will represent nodes present in respective row
        3) indexes maxRow to maxRow+maxCol will represent nodes 
           present in respective column  
        */

        DisjointSet ds = new DisjointSet(maxRow+maxCol + 2);
        Set<Integer> set = new HashSet<>(); // stores all NodeRows & NodeColumns
        for(int[] arr : stones ){
            int nodeRow = arr[0];
            int nodeCol = arr[1] + maxRow + 1;

            int ult_nodeRow = ds.findUParent(nodeRow);
            int ult_nodeCol = ds.findUParent(nodeCol);

            if(ult_nodeRow == ult_nodeCol) continue;

            ds.unionBySize(ult_nodeRow,ult_nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }
        
        //find the number of componenets
        int numberOfComponents = 0 ;
        for(int it : set ){
            if( it == ds.findUParent(it)) numberOfComponents += 1;
        }
        
        //just take 1 node from each componenet , rest all stones can be removed
        return totalStones - numberOfComponents;
    }
}