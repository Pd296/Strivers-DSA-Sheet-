class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f=new int[26];
        for(int i:tasks) f[i-'A']++;
        int ans=0;
        PriorityQueue<Integer> x=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:f) {
            if(i>0) x.add(i);
        }
        while(!x.isEmpty()){
            ArrayList<Integer> y=new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!x.isEmpty()){
                    int freq=x.poll();
                    freq--;
                    if(freq>0) y.add(freq);
                }
                ans++;
                if(x.isEmpty() && y.isEmpty()) break;
            }
            for (int i:y) x.add(i);
        }
        return ans;
    }
}