// Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* slow = head;
        ListNode* fast = head;
        for(int i = 0;i < n;i++) {
            fast = fast->next;
        }
        if(fast == NULL) {
            return head->next;
        }
        while(fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next;
        }
        slow->next = slow->next->next;
        return head;
    }
};
