import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        int[][] colorCounts = new int[n][26];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build graph and indegree array
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            indegree[y]++;
        }

        // BFS using Queue
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                colorCounts[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int maxColorCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            for (int neighbor : graph.get(node)) {
                // Update color counts
                for (int c = 0; c < 26; c++) {
                    colorCounts[neighbor][c] = Math.max(colorCounts[neighbor][c], colorCounts[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    int colorIndex = colors.charAt(neighbor) - 'a';
                    colorCounts[neighbor][colorIndex]++;
                    queue.offer(neighbor);
                }
            }

            // Track max value
            for (int c = 0; c < 26; c++) {
                maxColorCount = Math.max(maxColorCount, colorCounts[node][c]);
            }
        }
        return (visited == n) ? maxColorCount : -1;
    }
}

// time O(E + V)
// space O(E + V)