/*
  Problem Link : https://leetcode.com/problems/maximal-rectangle/
  Date : 2nd Sept 2025 
  
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col+1];
        int max_area = 0;
        for(int i=0;i<row; i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int area = maxHistogramArea(heights);
            max_area = max_area>area?max_area:area;
        }
        
        return max_area;
    }

    public int maxHistogramArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max_area=0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty()?i:(i-stack.peek()-1);
                max_area = max_area>(height*width)?max_area:(height*width);
            }
            stack.push(i);
        }
        return max_area;
    }
}
