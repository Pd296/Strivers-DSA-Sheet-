class Solution {
    public int minAddToMakeValid(String s) {
        int balance_count = 0 ;
        int imbalance_count = 0 ;
        for (char c : s.toCharArray()) {
            if (c == '(') balance_count++;
            else if(balance_count==0) imbalance_count++;
            else balance_count--;
        }
        return balance_count+imbalance_count;
    }
}