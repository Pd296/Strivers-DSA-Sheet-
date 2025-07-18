class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans=0;
        int[] h=new int[heights.length+1];
        for(int i=0;i<heights.length;i++) h[i]=heights[i];
        h[heights.length]=0;
        for(int i=0;i<=heights.length;i++){
            while(!stack.isEmpty() && h[i]<h[stack.peek()]){
                int height=h[stack.pop()]; 
                int width=stack.isEmpty()?i:i-stack.peek()- 1;
                int area=height*width;
                ans=Math.max(ans,area);
            }
            stack.push(i);
        }

        return ans;
    }
}