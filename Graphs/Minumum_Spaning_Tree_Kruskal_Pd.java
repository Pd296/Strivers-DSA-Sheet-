/*

   Problem Link : https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
   Date : 6th October 2025

 */

// Using Disjoint Set (Union by Size and Path Compression)
class DisjointSet {
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        Arrays.fill(size,1); //initially size of each component is 1
        for(int i=0;i<n;i++) parent[i]=i; //initially parent of each node is itself
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
    public int spanningTree(int V, int[][] edges) {

    Arrays.sort(edges,(a,b)->a[2]-b[2]); // sort based on weight
    DisjointSet ds = new DisjointSet(V); 
    int minimumSpanningWeight = 0;
    
    for(int[] arr : edges ){
        
        int u = arr[0];
        int v = arr[1];
        int wt =  arr[2];
        
        if( ds.findUParent(u) == ds.findUParent(v)) continue ;
        
        ds.unionBySize(u,v);
        minimumSpanningWeight += wt ;
    }
    
    return minimumSpanningWeight;
    }
}
