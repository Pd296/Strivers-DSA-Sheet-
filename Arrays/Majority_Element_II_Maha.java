class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        HashMap<Integer,Integer> x=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int i:nums) x.put(i,x.getOrDefault(i,0)+1);
        for(Map.Entry<Integer,Integer> m:x.entrySet()){
            if(m.getValue()>n) ans.add(m.getKey());
        }
        return ans;
    }
}