

//3-jul-2025
//problem link-https://www.geeksforgeeks.org/allocate-minimum-number-of-pages/1


//Back-end complete function Template for Java

class Solution {
   static int is_allocated(int[] arr,int k,int max_pages){
       int students=1;
       int pages=0;
       for(int i=0;i<arr.length;i++){
           if(pages+arr[i]<=max_pages){
               pages+=arr[i];
           }
           else{
               pages=arr[i];
               students++;
           }
       }
       return students;
   } 
    public static int findPages(int[] arr, int k) {
        int n=arr.length;
        if(n<k) return -1;
        long right=0;
        int left=0;
        for(int i:arr){
            right+=i;
            left=Math.max(left,i);
        }
        if(n==k) return left;
        while(left<=right){
            int mid=(int)(right-left)/2+left;
            int students=is_allocated(arr,k,mid);
            if(students>k){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
        
    }
}