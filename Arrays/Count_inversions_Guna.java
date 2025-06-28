// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int miner(int[] arr,int start,int end){
        if(start==end) return 0;
        int mid=(end-start)/2+start;
        int sum1=miner(arr,start,mid);
        int sum2=miner(arr,mid+1,end);
        int[] temp=new int[end-start+1];
        int temp_ite=0;
        int left=start;
        int right=mid+1;
        int count=0;
        while(left<=mid && right<=end){
            if(arr[left]>arr[right]){
                temp[temp_ite]=arr[right];
                count=count+mid-left+1;
                right++;
            }
            else{
                temp[temp_ite]=arr[left];
                left++;
            }
            temp_ite++;
        }
        while(left<=mid){
            temp[temp_ite]=arr[left];
            temp_ite++;
            left++;
        }
        while(right<=end){
            temp[temp_ite]=arr[right];
            temp_ite++;
            right++;
        }
        for(int i=0;i<temp.length;i++){
            arr[start]=temp[i];
            start++;
        }
        return count+sum1+sum2;
    }
    static int inversionCount(int arr[]) {
        return miner(arr,0,arr.length-1);
    }
}