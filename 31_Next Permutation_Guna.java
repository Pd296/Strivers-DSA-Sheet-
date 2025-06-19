

//Leetcode
//31. Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;
        int i=nums.length-2;

        while(i>=0 && nums[i]>=nums[i+1]){
            //Find the where the increasing order is breaking from the end
            i--;
        }
        if(i>=0){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    //Swap with next largest number
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
        }

        //sorting the remaining array
        int end=nums.length-1;
        int start=i+1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return;
    }
}

/*
1234
1243
1324
1342
1423
1432
2134
2143

147865
148567
*/