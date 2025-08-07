/*

Problem Link : https://leetcode.com/problems/sliding-window-maximum/
Date : 28th July 2025 

 */


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       
       int n = nums.length;
       int[] result= new int[n-k+1];
       int j=0;
       Deque<Integer> deque = new ArrayDeque<>(k);

       for(int i=0;i<n;i++){

           int current = nums[i];
           
           // remove the elements from the Deque which are out of window 
           if(!deque.isEmpty() && deque.peekFirst() <= i-k)
               deque.removeFirst();

           //remove smaller Elements from the Deque . We are Decreasing maintaining a monotonic stack 
           while(!deque.isEmpty() && current >= nums[deque.peekLast()]) 
                deque.removeLast();

            deque.addLast(i);
            
            //wait until we have seen K elements and then add to your result
            if( i>=k-1) {
                //add the max for this window
                result[j] = nums[deque.peekFirst()]; 
                j++;
            }

       }

       return result;

    }
}