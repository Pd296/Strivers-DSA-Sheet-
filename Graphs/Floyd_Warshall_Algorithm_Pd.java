/*

  Problem Link : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
  Date : 20th September 2025
  
 */

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        //create a matrix to store the distance 
        int[][] mat = new int[n][n];
        for(int[] arr:mat)Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i=0;i<n;i++)mat[i][i]=0;

        for(int[] arr:edges){
            int src=arr[0];
            int dst=arr[1];
            int cost=arr[2];
            mat[src][dst]=cost;
            mat[dst][src]=cost;
        }

        //pass through each city(k) for evey i to j
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]==Integer.MAX_VALUE || 
                    mat[k][j]==Integer.MAX_VALUE)  continue;

                    mat[i][j]=Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }
        
        //determine the candidate city 
        int candidateCity=0;
        int minCities=n+1;

          for(int i=0;i<n;i++){
                 int city=i;
                 int current=0;
                for(int j=0;j<n;j++){
                     if(i==j)continue;
                     if(mat[i][j]<=distanceThreshold) current++;
                }
                if(current <= minCities){
                    minCities=current;
                    candidateCity=city;
                }
            }

        return candidateCity;
    }
}