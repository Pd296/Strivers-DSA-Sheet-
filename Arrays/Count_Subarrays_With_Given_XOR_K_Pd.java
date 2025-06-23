/*
Date : 23rd June 2025
Problem link : https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k
*/

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      
         int n=nums.length;
         Map<Integer,Integer> map = new HashMap<>();
         map.put(0,1);

         int xor = 0;
         int count = 0;
         for(int i=0;i<n;i++){
            xor ^= nums[i];

            int x= xor ^ k;
            if(map.containsKey(x)) count += map.get(x);
            map.put(xor,map.getOrDefault(xor,0)+1);

         }
         return count;
    }
}