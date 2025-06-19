class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        for(;i>=0 && nums[i]>=nums[i+1];i--){}
        if(i<0){
            for(int in = 0;in<nums.length/2;in++) {
                int tem=nums[in];
                nums[in]=nums[nums.length-1-in];
                nums[nums.length-1-in]=tem;
            }
        }
        else{
            int j=nums.length-1;
            for(;j>=0 && nums[j]<=nums[i];j--){}
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            int x=i+1;
            int y=nums.length-1;
            while (x < y) {
                int tem = nums[x];
                nums[x++] = nums[y];
                nums[y--] = tem;
            }
        }
    }
}