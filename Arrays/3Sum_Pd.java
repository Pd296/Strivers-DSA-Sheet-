/*
Date : 20th June 2025 
Problem link : https://leetcode.com/problems/3sum/
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n-2;i++){
            //prevent Duplicates - move until the last occurance 
            while(i>0 && i<n-2 && nums[i]==nums[i-1]) i+=1;
            int firstElement=nums[i];

            int j=i+1;
            int k=n-1;
            while(j<k && j<n){
                //System.out.println(i+" "+j+" "+k);
                int secondElement = nums[j];
                int thirdElement = nums[k];
                int sum=firstElement + secondElement + thirdElement;
                
                if(sum == 0){
                List<Integer> list = Arrays.asList(firstElement,secondElement,thirdElement);
                result.add(list);

                //prevent Duplicates - move until the last occurance
                while(j<k && nums[j]==nums[j+1]) j+=1;
                while( k>j && nums[k]==nums[k-1]) k-=1;
                j+=1;
                k-=1;

                }
                else if(sum < 0) j+=1;
                else if (sum > 0) k-=1;
            }
        }

       return result;
    }
}


/*
array = [-1,0,1,2,-1,-4]

sortArray = [-4,-1,-1,0,1,2]
firstEle = -4

secondEle -> -1 to 2
ThirdEle -> 2 to -1

*/