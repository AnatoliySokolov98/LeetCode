import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> level = new ArrayList<>();
        if (n == 1) {
            level.add(0);
            return level;
        }
        int[] indegrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            indegrees[x]++;
            indegrees[y]++;
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 1) {
                level.add(i);
            }
        }

        while (true) {
            List<Integer> nextLevel = new ArrayList<>();
            for (int node : level) {
                for (int child : graph.get(node)) {
                    indegrees[child]--;
                    if (indegrees[child] == 1) {
                        nextLevel.add(child);
                    }
                }
            }
            if (nextLevel.isEmpty()) {
                return level;
            }
            level = nextLevel;
        }
    }
}

// time O(n)
// space O(n)