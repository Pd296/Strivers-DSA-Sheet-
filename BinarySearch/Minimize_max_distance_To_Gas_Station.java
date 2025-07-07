// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double low=0;
        double high=0;
        for(int i=1;i<stations.length;i++){
            high=Math.max(high,stations[i]-stations[i-1]);
        }
        while(high-low>1e-6){
            double mid=(low+high)/2;
            if(canPlace(stations,k,mid)) high=mid;
            else low=mid;
        }
        return Math.round(high*100.0)/100.0;
    }
    public static boolean canPlace(int[] stations,int k,double d){
        int u=0;
        for(int i=1;i<stations.length;i++){
            double g=stations[i]-stations[i-1];
            u=u+(int)(g/d);
        }
        return u<=k;
    }
}
