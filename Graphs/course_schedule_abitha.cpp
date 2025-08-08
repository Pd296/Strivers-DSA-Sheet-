// Problem Link : https://leetcode.com/problems/course-schedule-ii/description/


class Solution {
  public:
  bool dfs(int node, vector<vector<int>>& graph, vector<int>& visited, vector<int>& stack) {
    visited[node] = 1; // mark as visiting
    for (int i : graph[node]) {
        if (visited[i] == 1) {
            return false; // cycle detected
        }
        else if (visited[i] == 0) {
            if (!dfs(i, graph, visited, stack)) {
                return false;
            }
        }
    }
    visited[node] = 2; // mark as visited
    stack.push_back(node);
    // cout << " node is" << node << '\n';
    return true;
}

    vector<int> findOrder(int n, vector<vector<int>>& prerequisites) {
    vector<vector<int>> graph(n);
    for (auto& it : prerequisites) {
        int course = it[0];
        int pre = it[1];
        graph[pre].push_back(course);
    }

    vector<int> visited(n, 0);
    vector<int> stack;
    for (int i = 0; i < n; i++) {
        if (visited[i] == 0) {
            if (!dfs(i, graph, visited, stack)) {
                return {}; // cycle detected
            }
        }
    }

    reverse(stack.begin(), stack.end());
    return stack;
}
};


