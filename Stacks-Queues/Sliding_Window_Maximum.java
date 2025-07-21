class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int in=0;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1) ans[in++]=nums[dq.peekFirst()];
        }
        return ans;
    }
}