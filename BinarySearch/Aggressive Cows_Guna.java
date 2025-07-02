

//2-jul-2025
//problem link-https://www.geeksforgeeks.org/problems/aggressive-cows/1

// User function Template for Java
class Solution {
   static boolean is_possible(int[] stalls,int k,int dis){
        int prev_stall=stalls[0];
        k--;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-prev_stall>=dis){
                prev_stall=stalls[i];
                k--;
            }
            if(k<=0) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n=stalls.length;
        int left=1;
        int right=stalls[n-1];
        int dis=0;
        int ans=0;
        while(left<right){
            dis=(right-left)/2+left;
            if(is_possible(stalls,k,dis)){
                ans=Math.max(ans,dis);
                left=dis+1;
            }
            else{
                right=dis-1;
            }
        }
        if(is_possible(stalls,k,left)) return Math.max(left,ans);
        return ans;
    }
}