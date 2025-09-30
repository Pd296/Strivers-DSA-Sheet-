//Problem statement - https://leetcode.com/problems/rotate-array/description/
//29 Sept 2025
class Solution {
    public void rotate(int[] nums, int k) {
        if(k>0){
            k=k%nums.length;
            int[] firstknum = new int[k];
            int j=0;
            for(int i=nums.length-k;i<nums.length;i++){
                firstknum[j++]=nums[i];
            }
            for(int i=nums.length-k-1;i>=0;i--){
                nums[i+k]=nums[i];
            }
            for(int i=0;i<k;i++){
                nums[i]=firstknum[i];
            }
        } 
    }
}
