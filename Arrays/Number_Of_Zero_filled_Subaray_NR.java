// Problem Statement - https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
//29 Sept 2025
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarrcount=0;
        int j=0;
        if(nums[0]==0) subarrcount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0 && nums[j]!=0){
                j=i;
                subarrcount++;
            }else if(nums[i]!=0) j=i;
            else {
                subarrcount+=i-j+1;
            }
        }
        return subarrcount;
    }
}
