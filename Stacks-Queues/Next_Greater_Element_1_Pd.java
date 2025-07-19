/*

Date : 19th July 2025
Problem Link : https://leetcode.com/problems/next-greater-element-i/

 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();
        //map is just to reference the index of the number  
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums2.length;

        //stores the next greater element for the elements in nums2 array 
        int[] nge = new int[n];

        for(int i=n-1;i>=0;i--){
            
            map.put(nums2[i],i);
            int currNumber = nums2[i];
            while(!stack.isEmpty() && currNumber >nums2[stack.peek()]){
                   stack.pop();
            }
            nge[i] = stack.isEmpty()?-1:nums2[stack.peek()];
            stack.push(i);
        }
        
        //refer the nge from nums2 array to create the nge of nums1 array
        int m = nums1.length;
        int[] result = new int[m];
        for(int i=0;i<m;i++){
            int index = map.get(nums1[i]);
            result[i]= nge[index];
        }

        return result;

    }
}