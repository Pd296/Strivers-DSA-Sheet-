
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length) return -1;
        int low=Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        int result=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(allocate(arr,k,mid)){
                result=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return result;
    }
    public static boolean allocate(int[] arr,int k,int m){
        int s=1;
        int p=0;
        for(int i=0;i<arr.length;i++){
            if(p+arr[i]>m){
                s++;
                p=arr[i];
                if(s>k) return false;
            }
            else{
                p=p+arr[i];
            }
        }
        return true;
    }
}