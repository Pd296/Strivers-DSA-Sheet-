
//date-15-jul-2025
//link-https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int max_area=0;
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                //calculating area for current popping element
                int cur_calc_bar=st.pop();
                int nse_ind=i;
                int pse_ind=-1;
                if(!st.isEmpty()){
                    pse_ind=st.peek();
                }
                max_area=Math.max(max_area,heights[cur_calc_bar]*(nse_ind-pse_ind-1));
            }
            st.push(i);
        }
        //this is to empty stack.. to check for strictly increasing peice of histogram 
        while(!st.isEmpty()){
            int cur_calc_bar=st.pop();
            //System.out.print(cur_calc_bar+",");
            int nse_ind=n;
            int pse_ind=-1;
            if(!st.isEmpty()){
                    pse_ind=st.peek();
                }
                max_area=Math.max(max_area,heights[cur_calc_bar]*(nse_ind-pse_ind-1));
        }
        return max_area;
    }
}