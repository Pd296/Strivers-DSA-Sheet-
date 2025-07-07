class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> x =new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),x);
        return x;
    }
    public void backtrack(int in,int[] nums,List<Integer> y,List<List<Integer>> x){
        x.add(new ArrayList<>(y));
        for(int i=in;i<nums.length;i++){
            y.add(nums[i]);
            backtrack(i+1,nums,y,x);
            y.remove(y.size()-1);
        }
    }
}