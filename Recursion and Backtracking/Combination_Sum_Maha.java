class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> x=new ArrayList<>();
        backtrack(0,new ArrayList<>(),x,target,candidates);
        return x;
    }
    public static void backtrack(int i,List<Integer> y, List<List<Integer>> x, int target,int[] candidates){
        if(i==candidates.length){
            if(target==0) x.add(new ArrayList<>(y));
            return;
        }
        if (candidates[i]<=target) {
            y.add(candidates[i]);
            backtrack(i,y,x,target-candidates[i],candidates);
            y.remove(y.size()-1);
        }
        backtrack(i+1,y,x,target,candidates);
    }
}