// Problem Link : https://leetcode.com/problems/task-scheduler/description/

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> cnt(26,0);
        for(int i = 0;i < tasks.size();i++) {
            cnt[tasks[i]-'A']++;
        }
        priority_queue<int> pq;
        for(int i = 0;i < 26;i++) {
            if(cnt[i]) {
                pq.push(cnt[i]);
            }
        }
        int time = 0;
        while(!pq.empty()) {
            int cycle = n+1; //per cycle
            vector<int> extra;

            while(cycle && !pq.empty()) {
                int top = pq.top();
                if(top > 1) {
                    extra.push_back(top-1);
                }
                pq.pop();
                time++;
                cycle--;
            }

            for(int c: extra) {
                pq.push(c);
            }
            if(pq.empty()) {
                break;
            }
            time += cycle; //add the null values
        }
        return time;
    }
};
