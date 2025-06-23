class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        // int ans=0;
        // for(int i=0;i<arr.length;i++){
        //     int sum = 0;
        //     for(int j=i;j<arr.length;j++){
        //         sum^=arr[j];
        //         if(sum == k) ans++;
        //     }
        // }
        // return ans;
        
        int ans=0;
        HashMap<Integer,Integer> x=new HashMap<>();
        int prev=0;
        for(int i:arr){
            prev=prev^i;
            ans=ans+x.getOrDefault(prev^k,0);
            if(prev==k) ans++;
            x.put(prev, x.getOrDefault(prev, 0) + 1);
            
        }
        return ans;
    }
}