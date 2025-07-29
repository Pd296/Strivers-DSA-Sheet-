/*

Problem Link : https://leetcode.com/problems/asteroid-collision/
Date : 28th July 2025

 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            int current = asteroids[i];
            //push the current element if it is greater than 0 
            if (current > 0)
                stack.push(current);
            else {
                
                //pop until stack.peek() is lesser than current element
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(current)) {
                    stack.pop();
                }

                //check if the current element is of equal weight as stack.peek
                if (!stack.isEmpty() && stack.peek() == Math.abs(current))
                    stack.pop();
                // push the current to the stack
                else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(current);

            }
        }

        int size = stack.size();
        //store the result in array
        int result[] = new int[size];
        for (int i = size - 1; i >= 0; i--)
            result[i] = stack.pop();

        return result;

    }
}