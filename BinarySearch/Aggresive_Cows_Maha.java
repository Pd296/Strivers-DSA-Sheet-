// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int ans=0;
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(checkDistance(stalls,k,mid)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
        
    }
    public static boolean checkDistance(int[] stalls,int k,int d){
        int v=1;
        int prev=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-prev>=d){
                v++;
                prev=stalls[i];
            }
        }
        return v>=k;
    }
}