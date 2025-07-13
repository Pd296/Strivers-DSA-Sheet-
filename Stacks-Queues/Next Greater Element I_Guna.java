
//date-13-jul
//link-https://leetcode.com/problems/next-greater-element-i/description/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2=nums2.length-1;
        Deque<Integer> stack =new ArrayDeque<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=n2;i>=0;i--){
            while(!stack.isEmpty()){
                if(stack.peek()>nums2[i]){
                    map.put(nums2[i],stack.peek());
                    //stack.push(nums[i]);
                    break;
                }
                else stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
                //stack.push(nums[i])
            }
            stack.push(nums2[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}