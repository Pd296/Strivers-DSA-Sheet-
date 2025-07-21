/*

Date : 21st July 2025
Problem Link : https://leetcode.com/problems/largest-rectangle-in-histogram/

 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] nse = findNextSmallerElement(heights);
        int[] pse = findPreviousSmallerElement(heights);

        int maxArea = 0;
        for(int i=0;i<n;i++){

            int leftIndex = pse[i] + 1 ;
            int rightIndex = nse[i] - 1 ;
            int current = heights[i];

            int area = (rightIndex - leftIndex + 1 ) * current;
            maxArea = Math.max(area,maxArea);

        }

        return maxArea;
    }

    private int[] findNextSmallerElement(int[] heights){
          
          int n = heights.length;
          int[] nse = new int[n];
          Stack<Integer> stack = new Stack<>();

          for(int i=n-1;i>=0;i--){
            int current = heights[i];
            while(!stack.isEmpty() && current <= heights[stack.peek()]){
                int pop = stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();
        return nse;

    }

    private int[] findPreviousSmallerElement(int[] heights){

          int n = heights.length;
          int[] pse = new int[n];
          Stack<Integer> stack = new Stack<>();

          for(int i=0;i<n;i++){

                int current = heights[i];

                while(!stack.isEmpty() && current <= heights[stack.peek()]){
                    int pop = stack.pop();
                }

                pse[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
          }

          stack.clear();
          return pse;
    }
}