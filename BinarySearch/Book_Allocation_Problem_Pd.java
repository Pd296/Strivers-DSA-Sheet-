/*
Date : 3rd July 2025
Problem Link : https://takeuforward.org/plus/dsa/problems/book-allocation-problem
*/

class Solution {
    public int findPages(int[] nums, int m) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = nums[0];
        int high = nums[n-1];
        int answer = -1;
        while(low <= high){

            int mid = low + (high -low)/2;
            if(isPossible(mid,nums,m)){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int pagesReadNow,int[] nums,int m){

        long sum = 0;
        int counter = 1;

        for(int i=0;i<nums.length;i++){

            sum += nums[i];
            if(sum >= pagesReadNow){
                counter += 1;
                sum=0;
            }
            if(counter >= m) return true;
        }
        return false;
    }
}