class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[mid+1]) low=mid+1;
            else high=mid;
        }
        return low;
        // int n=nums.length;
        // if(n==1) return 0;
        // if(nums[0]>nums[1]) return 0;
        // if(nums[n-1]>nums[n-2]) return n-1;

        // for(int i=1;i<n-1;i++){
        //     if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        // }
        
        // return 0;
    }
}