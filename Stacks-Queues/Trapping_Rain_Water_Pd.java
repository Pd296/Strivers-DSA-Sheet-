/*

Date : 19th July 2025
Problem Link : https://leetcode.com/problems/trapping-rain-water/

*/

class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int total = 0;

        int left_pointer = 0;
        int right_pointer = n - 1;

        int max_left = height[0];
        int max_right = height[n - 1];

        while (left_pointer < right_pointer) {

            if (height[left_pointer] < height[right_pointer]) {
                if (height[left_pointer] >= max_left) {
                    max_left = height[left_pointer];
                } else {
                    total += max_left - height[left_pointer];
                }
                left_pointer++;
            } else {

                if (height[right_pointer] >= max_right) {
                    max_right = height[right_pointer];
                } else {
                    total += max_right - height[right_pointer];
                }
                right_pointer--;
            }

        }

        return total;
    }
}