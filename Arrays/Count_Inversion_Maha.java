// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr,0,arr.length-1);
    }
    static int mergeSort(int[] arr,int l,int r){
        int ans=0;
        if(l<r){
            int m = (l+r)/2;
            ans=ans+mergeSort(arr,l,m);
            ans=ans+mergeSort(arr,m+1,r);
            ans=ans+merge(arr,l,m,r);
        }
        return ans;
    }
    static int merge(int[] arr,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++) L[i]=arr[l+i];
        for(int j=0;j<n2;j++) R[j]=arr[m+1+j];
        int count=0;
        int i=0,j=0,k=l;
        while (i<n1 && j<n2){
            if (L[i]<=R[j]){
                arr[k++]=L[i++];
            } else {
                arr[k++]=R[j++];
                count=count+(n1 - i);
            }
        }
        while(i<n1) arr[k++]=L[i++];
        while(j<n2) arr[k++]=R[j++];

        return count;
        
    }
}