/*
Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int lo = 0, hi = n1;
        int n = (n1+n2);
        int left = (n1+n2+1)/2;
        int l1, l2, r1, r2;
        while(lo <= hi) {
            int mid1 = (lo+hi)/2;
            int mid2 = left - mid1;
            l1 = (mid1-1 >= 0) ? nums1[mid1-1] : INT_MIN;
            l2 = (mid2-1 >= 0) ? nums2[mid2-1] : INT_MIN;
            r1 = (mid1 < n1) ? nums1[mid1] : INT_MAX;
            r2 = (mid2 < n2) ? nums2[mid2] : INT_MAX;
            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 == 0 ) { return (double)(max(l1, l2)+min(r1,r2))/2.0; }
                else{ return max(l1, l2);}
            }
            else if(l1 > r2) { hi = mid1 - 1; }
            else { lo = mid1+ 1; }
        }
        return 0;

        
    }
};
