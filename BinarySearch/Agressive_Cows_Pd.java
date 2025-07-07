/*
Date : 3rd July 2025
Problem Link : https://www.geeksforgeeks.org/problems/aggressive-cows/1
*/
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1]-stalls[0];
        int answer = -1 ;
               
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            if(isPossible(mid,stalls,k)){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return answer;
    }
    private static boolean isPossible(int distance,int[] stalls,int k){
        int counter = 1;
        int lastCowIndex = 0;
        for(int i=1;i<stalls.length;i++){
            int difference = stalls[i] - stalls[lastCowIndex];
            if(difference >= distance) {
                 counter+=1;
                lastCowIndex = i;
            }
        }
        if(counter >= k)return true;
        return false;
    }
}