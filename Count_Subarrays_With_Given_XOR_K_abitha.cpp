/*
Date : 23rd June 2025
Problem link : https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k
*/

class Solution {
  public:
    long subarrayXor(vector<int> &arr, int k) {
        // code here
        // int c = 0;
        // int n = arr.size();
        // for(int i = 0;i < n; i++) {
        //     long x = arr[i];
        //     if(arr[i] == k) {
        //         c++;
        //     }
        //     for(int j = i+1;j < n;j++) {
        //         x = x ^ (arr[j]);
        //         if(x == k) {
        //             c++;
        //         }
        //     }
        // }
        // return c;
        
        //o(n2)
        //x = xr ^ k
        int xr = 0;
        map<int, int> mp;
        mp[xr]++; //0,1
        long cnt = 0;
        int n = arr.size();
        for(int i = 0;i < n;i++) {
            xr = xr ^ arr[i];
            int val = xr ^ k;
            cnt += mp[val];
            mp[xr]++;
        }
        return cnt;
        
        
    }
};
