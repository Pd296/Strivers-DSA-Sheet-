

//https://leetcode.com/problems/maximum-subarray/description/

class Solution {
    public int maxSubArray(int[] nums) {
        int sub_arr_sum=nums[0];
        int max_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sub_arr_sum<0){
                sub_arr_sum=0;
            }
            sub_arr_sum=sub_arr_sum+nums[i];
            max_sum=Math.max(max_sum,sub_arr_sum);
        }
        return max_sum;
    }
}