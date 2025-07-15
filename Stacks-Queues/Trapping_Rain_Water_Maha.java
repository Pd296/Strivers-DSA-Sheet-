class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans=0;
        for(int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom=stack.pop();
                if(stack.isEmpty()) break; 
                int left=stack.peek();
                int width=i-left-1;
                int h=Math.min(height[left], height[i]) - height[bottom];
                ans+=width*h;
            }
            stack.push(i);
        }
        return ans;
    }
}