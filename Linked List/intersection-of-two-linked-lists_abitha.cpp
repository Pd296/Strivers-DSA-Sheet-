// Problem Link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

class Solution {
public:
    int findLength(ListNode *head) {
        int cnt = 1;
        while(head != NULL && head->next != NULL) {
            head = head->next;
            cnt++;
        }
        return cnt;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int n1 = findLength(headA);
        int n2 = findLength(headB);
        int diff = n1-n2;
        cout << "diff is" << diff;
        ListNode *fast;
        ListNode *slow;
        if(diff >= 0) {
            //n1 is of more length
            fast = headA;
            slow = headB;
        }
        else {
            fast = headB;
            slow = headA;
            diff = diff * -1; //to make it positive
        }
        while(diff) {
            fast = fast->next;
            diff--;
        }
        while(slow != NULL && fast != NULL) {
            if(slow == fast) {
                return slow;
            }
            else{
                slow = slow->next;
                fast = fast->next;
            }
        }
        return NULL;
        

        // hashing
//         unordered_set<ListNode*> s;  
//         while(headA != NULL) {
//             s.insert(headA);
//             headA = headA->next;
//         }
//         while(headB != NULL) {
//             if(s.find(headB) == s.end()) {
//                 headB = headB->next;
//             }
//             else{
//                 return headB;
//             }
//         }
//         return NULL;
        
    }
};
