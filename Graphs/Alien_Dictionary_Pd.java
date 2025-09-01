/* 

  Problem Link : https://www.geeksforgeeks.org/problems/alien-dictionary/1?
  Date : 31st August 2025
  
 */


class Solution {
    public String findOrder(String[] words) {
        int n = words.length;

        // Build graph
        List<Set<Character>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new HashSet<>());
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        // Track all unique characters
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
                if (indegree[c - 'a'] == -1) indegree[c - 'a'] = 0;
            }
        }

        // Build edges
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Invalid case: prefix
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1 - 'a').contains(c2)) {
                        adj.get(c1 - 'a').add(c2);
                        indegree[c2 - 'a']++;
                    }
                    break; // only first mismatch matters
                }
            }
        }

        // Topological sort (Kahn's)
        Queue<Character> q = new LinkedList<>();
        for (char c : chars) {
            if (indegree[c - 'a'] == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);

            for (char nei : adj.get(curr - 'a')) {
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Check cycle
        if (sb.length() < chars.size()) return "";
        return sb.toString();
    }
}
