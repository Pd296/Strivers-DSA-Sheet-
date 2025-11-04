//https://leetcode.com/problems/repeated-string-match/


//solution 1
class Solution {
    public int repeatedStringMatch(String a, String b) {
        String repeat="";
        int ans=0;
        while(repeat.length()<b.length()){
            repeat=repeat+a;
            ans++;
        }
        if(repeat.contains(b)) return ans;
        repeat=repeat+a;
        ans++;
        if(repeat.contains(b)) return ans;
        return -1;
    }
}

//solution 2
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int base = 256;
        int mod = 1_000_000_007;
        int minRepeats = (a.length()+b.length()-1)/a.length();
        for(int i=minRepeats;i<=minRepeats+1;i++){
            String repeat=a.repeat(i);
            if(rabinKarpContains(repeat,b,base,mod)) return i;
        }
        return -1;
    }
    public boolean rabinKarpContains(String repeat,String b,int base,int mod){
        int n=repeat.length();
        int m=b.length();
        if(m>n) return false;
        long h=1;
        long hashRepeat=0;
        long hashBString=0;
        for(int i=0;i<m-1;i++) h=(h*base)%mod;
        for(int i=0;i<m;i++){
            hashRepeat=(hashRepeat*base+repeat.charAt(i))%mod;
            hashBString=(hashBString*base+b.charAt(i))%mod;
        }
        for(int i=0;i<=n-m;i++){
            if(hashRepeat==hashBString && repeat.substring(i,i+m).equals(b)) return true;
            if(i<n-m){
                hashRepeat=(hashRepeat-repeat.charAt(i)*h)%mod;
                if(hashRepeat<0) hashRepeat+=mod;
                hashRepeat=(hashRepeat*base+repeat.charAt(i+m))%mod;
            }
        }
        return false;
    }
}