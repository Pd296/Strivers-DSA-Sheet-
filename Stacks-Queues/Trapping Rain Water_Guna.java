
//date-15-jul-2025
//link-https://leetcode.com/problems/trapping-rain-water/description/

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] left_max=new int[n];
        int max=-1;
        for(int i=0;i<n;i++){
            left_max[i]=max;
            max=Math.max(max,height[i]);
        }
        int right_max=Math.max(-1,height[n-1]);
        int water=0;
        for(int i=n-2;i>0;i--){
            int min_h=Math.min(right_max,left_max[i]);
            if(min_h>height[i]){
                water+=min_h-height[i];
            }
            right_max=Math.max(right_max,height[i]);
        }
        return water;
    }
}