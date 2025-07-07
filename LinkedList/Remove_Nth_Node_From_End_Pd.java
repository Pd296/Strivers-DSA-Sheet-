/*
Date : 6th July 2025
Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode prev = new ListNode(-1);
       prev.next=head;

       ListNode fast = head;
       int counter=0;
       while(fast!=null && counter<n) {
          fast= fast.next;
          counter += 1;
       }
       
       if(fast == null) return head.next;

       ListNode slow = head;
       while( fast.next != null){
          fast = fast.next;
          slow = slow.next;
       }

       ListNode delNode = slow.next;
       slow.next=slow.next.next;
       return prev.next;

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */