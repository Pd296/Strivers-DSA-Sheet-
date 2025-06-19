/* 
Date : 19th June 2025
Problem Link : https://leetcode.com/problems/next-permutation/
*/
  

class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1) return ;

        int index=nums.length-2;

        //Step 1 - find the breaking point
        while( index >=0 && nums[index] >= nums[index+1]) index--;
        int breakingPoint = index;

        //Step 2 - swap with the next Greater Element 
        int nextGreaterIndex=n-1;
        if(breakingPoint >=0){
            while(nums[breakingPoint] >= nums[nextGreaterIndex])   
                nextGreaterIndex-=1;
            swap(nums,breakingPoint,nextGreaterIndex);   
        }

        // Step 3 - sort the array from index = BreakingPoint + 1

        reverse(nums,breakingPoint+1,n-1);
        return ;

    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i,j);
            i+=1;
            j-=1;
        }
    }
}


/*
dry run 

array =5, 4, 6, 3, 2, 1

step 1)
find the breaking point 
//breakingPoint = index 1

swap 4 and 6
//output -> 5,6,4,3,2,1

sort array from index 2 
//output -> 5,6,1,2,3,4 

*/