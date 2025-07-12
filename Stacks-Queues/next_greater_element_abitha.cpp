// Problem Link : https://leetcode.com/problems/next-greater-element-i/
class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        unordered_map<int, int> mp;
        stack<int> st;
        int n1 = nums1.size();
        int n2 = nums2.size();
        for(int i = n2-1;i>=0;i--) {
            if(i == n2-1) {
                mp.insert({nums2[i],-1});
            }
            else{
                while(!st.empty() && nums2[i] > st.top()) {
                    st.pop();
                }
                if(!st.empty()) {
                    mp.insert({nums2[i], st.top()});
                }
                else{
                    mp.insert({nums2[i],-1});
                }
                
            }
            st.push(nums2[i]);
        }      
        for(int i = 0;i < n1;i++) {
            res.push_back(mp[nums1[i]]);
        } 
        return res;

    }
};


