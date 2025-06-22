class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //There can only br 2 or less than 2 numbers
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        /*
        another approach of participation -- have to check more
        int num1=nums[0];
        int num2=nums[n-1];
        int num1_count=1;
        int num2_count=1;
        int p1=1;
        int p2=n-2;
        //if(num1==num2) num1_count++;
        while(p1<p2){
            System.out.print("num1_c="+num1_count+" num2_c="+num2_count);
            if(nums[p1]==num1) num1_count++;
            else{
                if(nums[p1]==num2) num2_count++;
                num1_count--;
            }
            if(nums[p2]==num2) num2_count++;
            else{
                if(nums[p2]==num1) num1_count++;
                num2_count--;
            }

            if(num1_count<=0){
                num1=nums[p1];
                num1_count=1;
            }
            if(num2_count<=0){
                num2=nums[p2];
                num2_count=1;
            }
            p1++;
            p2--;

        }*/
        int num1=0;
        int num2=0;
        int num1_count=0;
        int num2_count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1) num1_count++;
            else if(nums[i]==num2) num2_count++;
            else if(num1_count==0){
                num1=nums[i];
                num1_count++;
            }
            else if(num2_count==0){
                num2=nums[i];
                num2_count++;
            }
            else{
                num1_count--;
                num2_count--;
            }
        }
         num1_count=0;
         num2_count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1) num1_count++;
            if(nums[i]==num2) num2_count++;
        }
        if(num1_count>n/3) ans.add(num1);

        if(num1!=num2 && num2_count>n/3) ans.add(num2);
        return ans;
    }
}


/*
[2,3,2,3,2,4,3,2,3,4,4]
c1=2
c2=2
*/