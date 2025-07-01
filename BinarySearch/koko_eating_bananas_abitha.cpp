// Date 1-july-2025
//problem link-https://leetcode.com/problems/koko-eating-bananas/
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int lo = 1;
        int hi = *max_element(piles.begin(), piles.end());
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            double hrs=0;
            for(int i=0;i<piles.size();i++){
                hrs+=ceil((double)piles[i]/(double)mid);
            }
            if(hrs>h){
                lo = mid+1;
            }else {
                hi = mid-1;
            }
        }
        return lo;
    }
};
