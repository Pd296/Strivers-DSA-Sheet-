/*
Date : 27st June 2025
Problem link : https://takeuforward.org/plus/dsa/problems/count-inversions
*/

class Solution {
public:
    int cnt = 0;
    void merge(vector<int> nums, int lo, int hi) {
        int mid = (lo+hi)/2;
        int temp[hi-lo+1];
        int p1 = lo, p2 = mid+1, k = 0;
        while (p1 <= mid && p2 <= hi) {
            if (nums[p1] <= nums[p2]) {
                temp[k++] = nums[p1++];
            } else {
                cnt += (mid-p1+1);
                temp[k++] = nums[p2++];
            }
        }
        
        while (p1 <= mid) {
            temp[k++] = nums[p1++];
        }
        
        while (p2 <= hi) {
            temp[k++] = nums[p2++];
        }
        
        for (int i = 0; i < hi - lo + 1; i++) {
            nums[lo + i] = temp[i];
        }

    }
    void mergeSort(vector<int>& nums, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = (lo+hi)/2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        merge(nums, lo, hi);
    }
   long long int numberOfInversions(vector<int> nums) {
        cnt = 0;
        mergeSort(nums, 0, nums.size() - 1);
        return cnt;
    }
};
