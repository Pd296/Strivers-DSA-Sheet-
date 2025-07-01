/*
Date : 1st July 2025
Problem link : https://leetcode.com/problems/koko-eating-bananas/
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int low = 1;
        int high = (int)1e9;

        while(low <= high){

            int mid = low + (high-low)/2;
            long numberOfHours = findNumberOfHoursTaken(piles,mid);
            //System.out.println(low+" "+mid+" "+high+" "+numberOfHours);
            if(numberOfHours <= h) high = mid - 1;
            else if(numberOfHours > h) low = mid + 1;
            
        }
         return low;
    }
    private long findNumberOfHoursTaken(int[] piles,int k){

        long answer = 0;
        for(int i=0;i<piles.length;i++){
            int modulo = piles[i] % k;
            answer += modulo == 0 ? piles[i]/k : piles[i]/k +1;
        }
        return answer;
    } 
}