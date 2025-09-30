//Problem Statement - https://leetcode.com/problems/first-missing-positive/
// 30 Sept 2025
class Solution {
    public int firstMissingPositive(int[] nums) {
       
        HashSet<Integer> set = new HashSet<>();

        // Add all positive numbers to the set
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Check for the smallest missing positive
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }
}
