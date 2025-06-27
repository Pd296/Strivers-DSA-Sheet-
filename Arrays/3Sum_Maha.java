class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        HashSet<List<Integer>> x=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> y=new ArrayList<>();
                    y.add(nums[i]);
                    y.add(nums[j++]);
                    y.add(nums[k--]);
                    x.add(y);
                }
                else if(nums[i]+nums[j]+nums[k] < 0) j++;
                else k--;
            }
        }
        return new ArrayList<>(x);
    }
}