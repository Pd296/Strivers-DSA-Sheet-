
//date-17-jul-2025
//link-https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> window=new ArrayDeque<>();
       
       int[] ans=new int[nums.length-k+1];
       int ans_i=0;
       for(int i=0;i<nums.length;i++){
        if(!window.isEmpty() && window.peek()<i+1-k){
            window.poll();
        }
        while(!window.isEmpty() && nums[window.peekLast()]<nums[i]){
            window.pollLast();
        }
        
        window.offer(i);
        if(i>=k-1){
            ans[ans_i]=nums[window.peek()];
            ans_i++;
        }
       }
       return ans;
    }
}