class Solution {
    public int maxProduct(int[] nums) {
        /*
        //INITIAL SOLUTION -O(N)
        int neg_nums=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) neg_nums++;
        }
        int product=1;
        int max_product_L=nums[0];
        int max_product_R=nums[nums.length-1];
        int neg_nums_L=neg_nums;
        int neg_nums_R=neg_nums;
        for(int nums_i=0;nums_i<nums.length;nums_i++){
            product=product * nums[nums_i];
            max_product_L=Math.max(product,max_product_L);
            if(product==0) product=1;
            if(nums[nums_i]<0) neg_nums_L--;
            if(product<0 && neg_nums_L==0) product=1;
        }
        product=1;
        for(int nums_i=nums.length-1;nums_i>=0;nums_i--){
            product=product * nums[nums_i];
            max_product_R=Math.max(product,max_product_R);
             if(product==0) product=1;
             if(nums[nums_i]<0) neg_nums_R--;
             if(product<0 && neg_nums_R==0) product=1;
        }

        return Math.max(max_product_R,max_product_L);*/

        int max_product=Integer.MIN_VALUE;
        int L_product=1;
        int R_product=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            L_product=L_product * nums[i];
            R_product=R_product * nums[n-i-1];
            max_product=Math.max(max_product,Math.max(L_product,R_product));
            if(L_product==0) L_product=1;
            if(R_product==0) R_product=1;
        }
        return max_product;

    }
}