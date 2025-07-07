

//date- 1-jul-2025
//problem link-https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    boolean is_valid(int[] piles,int k,int h){
        for(int i=0;i<piles.length;i++){
            int q=piles[i]/k;
            int r=piles[i]%k;
            h=h-q;
            if(r>0) h--;
            if(h<0) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int right=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            right=Math.max(right,piles[i]);
        }
        int left=1;
        int mid=0;
        int k=Integer.MAX_VALUE;
        while(left<right){
            mid=(right-left)/2+left;
            if(is_valid(piles,mid,h)){
                k=Math.min(k,mid);
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        if(is_valid(piles,left,h)) return Math.min(left,k);
        return k;
    }
}