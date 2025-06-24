class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}