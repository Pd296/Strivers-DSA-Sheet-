class Solution {

    public int miner(int[] nums,int k,int i,int xor){
        if(i==nums.length){
            if(xor==k) return 1;
            else return 0;
        }
        
        int inc=miner(nums,k,i+1,xor^nums[i]);

        while(i<nums.length-1 && nums[i]<nums[i+1]) i++;
        int exc=miner(nums,k,i+1,xor);
        return inc+exc;
    }
    public int subarraysWithXorK(int[] nums, int k) {
      //int count=0;
      Arrays.sort(nums);
      return miner(nums,k,0,0);
    }
}