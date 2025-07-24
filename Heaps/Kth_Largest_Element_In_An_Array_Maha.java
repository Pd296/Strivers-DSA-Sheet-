class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> x=new PriorityQueue<>();
        for(int i:nums) {
             x.add(i);
            if(x.size()>k){
                x.poll();
            }
        }
        return x.peek();
    }
}