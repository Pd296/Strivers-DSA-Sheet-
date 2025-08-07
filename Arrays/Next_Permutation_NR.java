class Solution {
    public void nextPermutation(int[] nums) {
          int len = nums.length;
          int i = len-2;
          while (i>=0 && nums[i]>=nums[i+1]){
            i--;
          }
          if(i>=0){
            int j=len-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
          }
         reverse(nums,i+1,len-1);
    }


private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}
