// Problem link : https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        // priority_queue<pair<int,int>> q;
        // vector<int> res;
        // int n = nums.size();
        // for(int i = 0;i < k;i++) {
        //     q.push({nums[i],i});
        // }
        // res.push_back(q.top().first);
        // for(int i = k;i < n;i++) {  
        //     q.push({nums[i],i});
        //     while(q.top().second <= i-k) {
        //         q.pop();
        //     }
        //     res.push_back({q.top().first});
        // }
        // return res; 
        // nlogn


        vector<int> res;
        deque<int> d;
        int n = nums.size();
        for(int i = 0;i < k;i++) {
            while(!d.empty() && nums[i] >= nums[d.back()]) {
                d.pop_back();
            }
            d.push_back(i);
        }
        for(int i = k;i < n;i++) {
            res.push_back(nums[d.front()]);
            //remove oout of windo elements
            while(!d.empty() && d.front() <= i - k) {
                d.pop_front();
            }
            //remove elements whihc are small comapred to adding ele
            while(!d.empty() && nums[i] >= nums[d.back()]) {
                d.pop_back();
            }
            d.push_back(i);
        }
        res.push_back(nums[d.front()]);

        return res;
        //o(n)
    }
};
