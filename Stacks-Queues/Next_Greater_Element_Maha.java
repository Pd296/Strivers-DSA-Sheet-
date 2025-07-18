class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        HashMap<Integer,Integer> x=new HashMap<>();
        Stack<Integer> y=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!y.isEmpty() && y.peek()<=nums2[i]) y.pop();
            if(y.isEmpty()) x.put(nums2[i],-1);
            else x.put(nums2[i],y.peek());
            y.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = x.get(nums1[i]);
        }
        return ans;
    }
}