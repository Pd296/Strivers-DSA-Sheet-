/*

  Problem Link : https://leetcode.com/problems/path-with-minimum-effort/description/
  Date : 2nd September 2025
  
 */

class Point {
    int r;
    int c;
    int effortNeeded;
    Point(int r, int c, int effortNeeded) {
        this.r = r;
        this.c = c;
        this.effortNeeded = effortNeeded;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        int[] dir = {-1, 0, 1, 0, -1};
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.effortNeeded - b.effortNeeded);

        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int r = current.r;
            int c = current.c;
            int effortNeeded = current.effortNeeded;

            // If we've reached destination, return
            if (r == m - 1 && c == n - 1) {
                return effortNeeded;
            }

            // Skip if we already found a better path
            if (effortNeeded > dist[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int new_r = r + dir[i];
                int new_c = c + dir[i + 1];

                if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n) {
                    int effort = Math.abs(heights[new_r][new_c] - heights[r][c]);
                    int maxEffort = Math.max(effortNeeded, effort);

                    if (maxEffort < dist[new_r][new_c]) {
                        dist[new_r][new_c] = maxEffort;
                        pq.offer(new Point(new_r, new_c, maxEffort));
                    }
                }
            }
        }

        return -1; // should never happen
    }
}
