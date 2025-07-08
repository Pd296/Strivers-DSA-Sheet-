/*
Date : 7th July 2025
Problem Link : https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there can be no intersection
        if (headA == null || headB == null) return null;

        // Initialize two pointers for both lists
        ListNode runnerA = headA;
        ListNode runnerB = headB;

        // The idea: traverse both lists; when a pointer reaches the end, redirect it to the other list's head.
        // If the lists intersect, the pointers will meet at the intersection node after at most 2 passes.
        // If not, both will eventually become null at the same time.
        while (runnerA != runnerB) {
            // Move to the next node, or switch to the other list's head if at the end
            runnerA = (runnerA != null) ? runnerA.next : headB;
            runnerB = (runnerB != null) ? runnerB.next : headA;
        }

        // Either both are null (no intersection), or both point to the intersection node
        return runnerA;          
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */