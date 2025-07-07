class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long n=0;
        for(int i:piles) n=n+i;
        int low=(int)((n-1)/h)+1;
        int high=(int)((n-piles.length)/(h-piles.length+1))+1;
        while(low<high){
           int mid=low+(high-low)/2;
           long time=0;
            for(int i:piles){
                time+=(i-1)/mid+1;
            }
            if(time>h){
                low=mid+1;
            }
            else high=mid;
        }
        return low;

        // int low=1;
        // int high=0;
        // for(int i:piles){
        //     high=Math.max(high,i);
        // }
        // int ans=high;
        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     long time=0;
        //     for(int i:piles){
        //         time=time+((i+mid-1)/mid);
        //     }
        //     if(time<=h){
        //         ans=mid;
        //         high=mid-1;
        //     }
        //     else low=mid+1;
        // }
        // return ans;
    }
}