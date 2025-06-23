/*
Date : 22nd June 2025
Problem link : https://leetcode.com/problems/majority-element-ii/
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n=nums.length;
        int firstCandidate=Integer.MIN_VALUE;
        int secondCandidate=Integer.MIN_VALUE;
        int counter1=0;
        int counter2=0;
        
        //pick the candidates
        for(int i=0;i<n;i++){

            if(counter1==0 && nums[i] != secondCandidate){
                firstCandidate=nums[i];
                counter1=1;     
            }else if(counter2==0 && nums[i] != firstCandidate){
                secondCandidate=nums[i];
                counter2=1;     
            }else if(nums[i] == firstCandidate) {
               counter1+=1;
            }
            else if(nums[i] == secondCandidate){
                 counter2+=1;
            }
            else {
                counter1-=1;
                counter2-=1;
            }  
        }

        //verify whether the candidates are >n/3
        List<Integer> result = new ArrayList<>();
        int firstCandidateCounter = 0;
        int secondCandidateCounter = 0;
        for(int num : nums ){
            if(num == firstCandidate) firstCandidateCounter += 1;
            if(num == secondCandidate) secondCandidateCounter += 1;
        }
        
        if(firstCandidateCounter > n/3) result.add(firstCandidate);
        if(secondCandidateCounter > n/3) result.add(secondCandidate);
        return result;
    }
}