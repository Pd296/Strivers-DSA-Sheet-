// Problem Link : https://www.geeksforgeeks.org/problems/alien-dictionary/1?utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary&utm_source=youtube


class Solution {
  public:
    vector<int> topoSort(int vertices, vector<int> graph[], vector<bool> present) {
        // vector<int> inDegree(vertices, 0);
        int inDegree[26] = {0};
        for(int i = 0;i < vertices; i++) {
            if(!present[i]) continue;
            for(auto it: graph[i]) {
                inDegree[it]++; //check for how many a is ponited, how many incoming
            }
        }
        queue<int> q;
        for(int i = 0;i < vertices;i++) {
            if(present[i] && inDegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> result;
        while(!q.empty()) {
            int top = q.front();
            q.pop();
            result.push_back(top);
            for(auto it: graph[top]) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.push(it);
                }
            }
        }
        return result;
    }
    
    string findOrder(vector<string> &words) {
        // code here
        vector<int> graph[26];
        int presentCount = 0;
        vector<bool> present(26, false);
        for(int i = 0;i < words.size();i++) {
            for(int j = 0;j < words[i].size();j++) {
                if (!present[words[i][j] - 'a']) {
                    presentCount++;
                    present[words[i][j] - 'a'] = true;
                    //marking chars which are present
                }
            }
        }
        // vector<vector<int>> graph(k);

        for(int i = 0; i < words.size()-1;i++) {
            string &s1 = words[i];
            string &s2 = words[i+1];
            int len = min(s1.size(), s2.size());
            bool found = false;
            for(int j = 0;j < len;j++) {
                if(s1[j] != s2[j]) {
                    graph[s1[j]-'a'].push_back(s2[j]-'a');
                    found = true;
                    break;
                    //construct grap from strings
                    //abcd, abca => d > a => d-> a
                }
            }
            if(!found && s1.size() > s2.size()) {
                return "";
                //this is for abc, ab => but it should be ab,abc so wrong case
            }
        }
        vector<int> top = topoSort(26, graph, present);
        if(top.size() < presentCount) {
            return ""; ///check cycle
        }
        string res = "";
        for (int node : top) {
            if (present[node]) {
                res += (char)(node + 'a');
            }
        }
        return res;
    }
};
