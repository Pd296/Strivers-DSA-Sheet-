/*
Date : 28th June 2025
Problem link : https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number, https://leetcode.com/problems/set-mismatch/
*/


class Solution {
   public:
    int findRightMost(long long xr) {
        int ans = 0;
        while (xr) {
            if ((xr & 1) == 1) {
                return ans;
            } else {
                ans++;
                xr = xr >> 1;
            }
        }
        return ans;
    }
    vector<int> findMissingRepeatingNumbers(vector<int> arr) {
        int n = arr.size();
        long long xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i] ^ (i + 1);
        }
        // we got x ^ y = xr
        // find rightmost bit which is set
        int bitNo = findRightMost(xr);
        int b0 =
            0;  // xor woth this for values having unset nit in bitNo position
        int b1 = 0;  // xor woth this for values having set nit in bitNo
                     // position
        for (int i = 0; i < n; i++) {
            // int ai = (arr[i] & (1 << bitNo));
            // int bi = ((i+1) & (1 << bitNo));
            // cout << ai << " ai " << bi << " bi " << '\n';
            if ((arr[i] & (1 << bitNo)) != 0) {
                b1 = b1 ^ arr[i];
            } else {
                b0 = b0 ^ arr[i];
            }
            if (((i + 1) & (1 << bitNo)) != 0) {
                b1 = b1 ^ (i + 1);
            } else {
                b0 = b0 ^ (i + 1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == b0) {
                cnt++;
            }
        }
        vector<int> ans;
        if (cnt == 2) {
            return {b0, b1};
        } else {
            return {b1, b0};
        }

    }
};

