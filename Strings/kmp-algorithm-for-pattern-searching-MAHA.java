class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        if (m == 0 || n < m) return ans;
        char[] t = txt.toCharArray();
        char[] p = pat.toCharArray();
        int[] lps = new int[m];
        formLPS(p,lps);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (t[i] == p[j]) {
                i++;
                j++;
                if (j == m) {
                    ans.add(i - j);
                    j = lps[j - 1];
                }
            } 
            else if (j > 0) {
                j = lps[j - 1];
            } 
            else {
                i++;
            }
        }
        return ans;
    }
    void formLPS(char[] p, int[] lps) {
        int len = 0;
        for (int i = 1; i < p.length; ) {
            if (p[i] == p[len]) {
                lps[i++] = ++len;
            } 
            else if (len > 0) {
                len = lps[len - 1];
            } 
            else {
                lps[i++] = 0;
            }
        }
    }
}