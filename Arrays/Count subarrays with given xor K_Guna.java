class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      /*
      //O(n)^2 Approach
      int count=0;
      int n=nums.length;
      for(int i=0;i<n;i++){
        int xr=0;
        for(int j=i;j<n;j++){
            xr=xr ^ nums[j];
            if(xr==k) count++;
        }
      }
      return count;*/
      int xr=0;
      Map<Integer,Integer> map=new HashMap<>();
      map.put(0,1);
      int count=0;
      int n=nums.length;
      for(int i=0;i<n;i++){
        xr=xr ^ nums[i];

        int x=xr ^ k;
        if(map.containsKey(x)){
            count=count+map.get(x);
            map.put(x,map.get(x)+1);
        }
        else{
            map.put(x,1);
        }
      }
      return count;
    }
}