/*

   Problem Link : https://leetcode.com/problems/making-a-large-island/description/
   Date : 11th October 2025

 */

// Using Disjoint Set (Union by Size and Path Compression
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dir = {-1, 0, 1, 0, -1};

        // Step 1: Build DSU for all 1-cells
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = row + dir[k];
                    int nc = col + dir[k + 1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        int node = row * n + col;
                        int adjNode = nr * n + nc;
                        
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }

        // Step 2: Try flipping each 0
        int maxIsland = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;

                Set<Integer> parents = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = row + dir[k];
                    int nc = col + dir[k + 1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        int parent = ds.findUParent(nr * n + nc);
                        parents.add(parent);
                    }
                }

                int totalSize = 1; // for the flipped cell
                for (int p : parents) totalSize += ds.size[p];
                maxIsland = Math.max(maxIsland, totalSize);
            }
        }

        // Step 3: Handle case where grid already full of 1s
        for (int i = 0; i < n * n; i++) {
            if (ds.findUParent(i) == i)
                maxIsland = Math.max(maxIsland, ds.size[i]);
        }

        return maxIsland;
    }
}
