//problem link:https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        vector<vector<int>> dp(n,vector<int>(n,INT_MAX)); //dp matrix for floyd warshall algo
        
        //relaxing every edges and adding the path to dp matrix
        for(auto& i: edges){
            int u=i[0];
            int v=i[1];
            int w=i[2];
            dp[u][v]=w;
            dp[v][u]=w;
        }
        //flyod warshall algo 
        //since there is no possibilitiy of negative weights, we don't need to afarid of negative cycle
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    // to overcome interger overlow
                    if(dp[j][i]==INT_MAX || dp[i][k]==INT_MAX)continue;
                    dp[j][k]=min(dp[j][k],dp[j][i]+dp[i][k]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         cout<<dp[i][j]<<" ";
        //     }
        //     cout<<"\n";
        // }
        int noOfCity=INT_MAX;
        int resultCity=0;
       
        for(int i=0;i<n;i++){
            int cityCurr=0;
             //calculate total city within reach for ith city
            for(int j=0;j<n;j++){
                if(i!=j && dp[i][j]<=distanceThreshold){
                    cityCurr++;
                }
            }
            //if availability from ith city to other city are lesser than our previous one
            // update city count and resultant city
            if(cityCurr<=noOfCity){
                resultCity=max(resultCity,i);
                noOfCity=cityCurr;
            }
        }
        return resultCity;
    }
};

/*
Time complexity : O(n^3) 
Space complexity : O(n^2)*/