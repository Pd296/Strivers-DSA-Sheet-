//https://leetcode.com/problems/3sum/
//comments
/*
 Solution can be written in a much neat and simple way
 */


class Solution {
    int next_uniq_to_right(int[] nums,int cur_pos){
        while(cur_pos<nums.length-1 && nums[cur_pos]==nums[cur_pos+1]){
            cur_pos++;
        }
        return cur_pos+1;
    }
    int next_uniq_to_left(int[] nums,int cur_pos){
        while(cur_pos>0 && nums[cur_pos]==nums[cur_pos-1]){
            cur_pos--;
        }
        return cur_pos-1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;){
            int req_sum=0-nums[i];
             int start=i+1;
             int end=n-1;
             while(start<end && start<n && end>=0){
                //System.out.println("i="+i+"  "+"start="+start+"  end="+end);
                int temp_sum=nums[start]+nums[end];
                if(temp_sum==req_sum){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start=next_uniq_to_right(nums,start);
                    end=next_uniq_to_left(nums,end);
                } 
                else if(temp_sum<req_sum){
                    start=next_uniq_to_right(nums,start);
                }
                else{
                    end=next_uniq_to_left(nums,end);
                }
             }
             i=next_uniq_to_right(nums,i);
        }
        return ans;
    }
}

