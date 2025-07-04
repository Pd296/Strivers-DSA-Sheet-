
//4-jul-2025
//problem_link-https://leetcode.com/problems/median-of-two-sorted-arrays/description/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n2<n1) return findMedianSortedArrays(nums2,nums1);

        int left_half_len=(n1+n2+1)/2;
        int low=0;
        int high=n1;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left_half_len-mid1;
            int left_max_1=mid1>0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int left_max_2=mid2>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int right_min_1=mid1<n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int right_min_2=mid2<n2 ? nums2[mid2] : Integer.MAX_VALUE;
            //System.out.println(mid1+" "+mid2);
            //System.out.println(left_max_1+" "+left_max_2+" "+right_min_1+" "+right_min_2);
            if(Math.max(left_max_1,left_max_2)<=Math.min(right_min_1,right_min_2)){
                if((n1+n2)%2==1) return Math.max(left_max_1,left_max_2);
                else return (double)(Math.max(left_max_1,left_max_2)+Math.min(right_min_1,right_min_2))/2;
            }
            else if(left_max_1>right_min_2){
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        }
        return 0;
    }
}

//[1,2,4,5,6,8,9]
//[1,5,9,10,12,15,16]