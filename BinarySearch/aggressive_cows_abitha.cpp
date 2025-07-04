//2-jun-2025
//problem link-https://www.geeksforgeeks.org/problems/aggressive-cows/1
class Solution {
public:
    int findSpaceBw(vector<int> nums, int mid) {
        int cnt = 1;
        int sum = nums[0];
        for(int i = 1; i < nums.size();i++) {
            if(nums[i] - sum >= mid) {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt;
    }
    int aggressiveCows(vector<int> &nums, int k) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int mini = INT_MAX;
        for(int i = 1;i < n;i++) {
            mini = min(mini, (nums[i]-nums[i-1]));
        }
        int maxi = nums[n-1]-nums[0];
        while(mini <= maxi) {
            int mid = (maxi+mini)/2;
            int space = findSpaceBw(nums, mid);
            if(space < k) {
                maxi = mid-1;
            }
            else{
                mini = mid+1;
            }
        }
        return maxi;
        
    }
};
