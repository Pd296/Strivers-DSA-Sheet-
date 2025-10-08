//Problem statement - https://leetcode.com/problems/majority-element/
//29th Sept
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> ele_count = new HashMap<>();
        int max=1;
        int max_element=nums[0];
        ele_count.put(nums[0],1);
        for(int i=1;i<nums.length; i++){
            if(ele_count.containsKey(nums[i])){
                int count = ele_count.get(nums[i])+1;
                ele_count.put(nums[i],count);
                max_element=max>count?max_element:nums[i];
                max=max>count?max:count;
            }else{
                ele_count.put(nums[i],1);
            }
        }
        return max_element;
    }
}
