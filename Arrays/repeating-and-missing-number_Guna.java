// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int xr=0;
        int arr_len=arr.length;
        for(int arr_ind=0;arr_ind<arr_len;arr_ind++){
            xr=xr ^ arr[arr_ind] ^ (arr_ind+1);
        }
        //Finding the number with only first 1 bit from right as 1
        xr=xr & ~(xr-1);
        int zero=0;
        int one=0;
        for(int arr_ind=0;arr_ind<arr_len;arr_ind++){
            if((xr & arr[arr_ind]) == 0) zero=zero^arr[arr_ind];
            else one=one^arr[arr_ind];
            
            if((xr & arr_ind+1) ==0) zero=zero^(arr_ind+1);
            else one=one^(arr_ind+1);
        }
        
        int count=0;
        for(int arr_ind=0;arr_ind<arr_len;arr_ind++){
            if(arr[arr_ind]==zero) count++;
        }
        //System.out.println(zero+" "+one);
        
        if(count==0) return new ArrayList<>(List.of(one,zero));
        return new ArrayList<>(List.of(zero,one));
    }
}
