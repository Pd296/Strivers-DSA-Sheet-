
//19 july
//link-https://leetcode.com/problems/task-scheduler/description/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.offer(freq[i]);
        }
        int time=0;

        while(!pq.isEmpty()){
            int cur_cycle=n+1;
            List<Integer> used=new ArrayList<>();
            int intervals=0;
            while(cur_cycle>0 && !pq.isEmpty()){
                int cur_ele=pq.poll();
                //System.out.println(cur_ele);
                if(cur_ele>1) used.add(cur_ele-1);

                intervals++;
                cur_cycle--;
            }
            for(int i:used){
                pq.offer(i);
            }
            if(pq.isEmpty()){
                time+=intervals;
            }
            else{
                time+=n+1;
            }
        }
        return time;

    }
}