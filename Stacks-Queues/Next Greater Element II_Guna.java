
//date-13-jul-2025
//link-https://leetcode.com/problems/next-greater-element-ii/description/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        //iterating from end 
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    ans[i]=stack.peek();
                }
                else{
                    ans[i]=-1;
                }
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }
}