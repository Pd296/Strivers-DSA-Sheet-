class Solution {
    public int maxProduct(int[] nums) {
        int maxProd=nums[0];
        int minProd=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int v=maxProd;
            maxProd=Math.max(nums[i],Math.max(maxProd*nums[i],minProd*nums[i]));
            minProd=Math.min(nums[i],Math.min(v*nums[i],minProd*nums[i]));
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}