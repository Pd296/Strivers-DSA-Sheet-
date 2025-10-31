//Problem link:https://leetcode.com/problems/path-with-minimum-effort/

using tiii = tuple<int, int, int>;
class Solution
{
public:
    int row, col;
    vector<vector<int>> cost;
    const static constexpr int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int minimumEffortPath(vector<vector<int>> &heights)
    {
        row = heights.size();
        col = heights[0].size();
        // cout<<row<<" "<<col<<"\n";
        cost.resize(row, vector<int>(col, INT_MAX)); //vector to store minimum effort required to reach (i,j) point
        cost[0][0] = 0;
        priority_queue<tiii, vector<tiii>, greater<tiii>> pq;
        pq.emplace(0, 0, 0);
        //Dijkstra's algo
        while (!pq.empty())
        {
            auto [effort, i, j] = pq.top();
            pq.pop();
            if (i == row - 1 && j == col - 1)
            {
                cost[i][j] = cost[i][j] > effort ? effort : cost[i][j];
                continue;
            }
            for (auto &k : dir)
            {
                int x = k[0] + i;
                int y = k[1] + j;
                if (x >= 0 && x < row && y >= 0 && y < col)
                {
                    int effxy = abs(heights[i][j] - heights[x][y]);
                    effxy = effort > effxy ? effort : effxy;
                    if (cost[x][y] > effxy)
                    {
                        cost[x][y] = effxy;
                        pq.emplace(cost[x][y], x, y);
                    }
                }
            }
        }
        return cost[row - 1][col - 1];
    }
};