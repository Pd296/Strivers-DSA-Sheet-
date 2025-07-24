// Problem Link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> p;
        for(int i = 0;i < nums.size();i++) {
            p.push(nums[i]);
        }
        int val;
        for(int i = 0;i < k;i++) {
            val = p.top();
            p.pop();
        }
        return val;
    }
};
