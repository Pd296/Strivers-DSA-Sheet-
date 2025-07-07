/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // HashSet<ListNode> x=new HashSet<>();
        // while(head!=null){
        //     if(x.contains(head)) return true;
        //     else x.add(head);
        //     head=head.next;
        // }
        // return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        return false;
   }
}