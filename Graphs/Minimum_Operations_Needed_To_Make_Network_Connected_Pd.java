/*

   Problem Link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
   Date : 7th October 2025

 */

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
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds  = new DisjointSet(n);
        int extraConnectionsAvailable = 0;
        boolean[] visited = new boolean[n];
        
        // count extra connections available and do union operation
        for(int[] arr : connections){

            int nodeU = arr[0];
            int nodeV = arr[1];

            visited[nodeU]=true;
            visited[nodeV]=true;

            int ultParentU = ds.findUParent(nodeU);
            int ultParentV = ds.findUParent(nodeV);

            if(ultParentU == ultParentV) {
                extraConnectionsAvailable += 1 ;
                continue;
            }

            ds.unionBySize(nodeU,nodeV);
        } 
     
        // count number of components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUParent(i) == i) components++;
        }

        // count number of components not visited
        int requiredConnections = components - 1;

        /* 
        if extraConnectionsAvailable >= requiredConnections then return requiredConnections else return -1
        */
        return extraConnectionsAvailable >= requiredConnections ?  requiredConnections : -1;
    }
}