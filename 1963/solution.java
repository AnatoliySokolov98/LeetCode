import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        Deque<Integer> bfs = new ArrayDeque<>();
        bfs.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (!bfs.isEmpty()) {
            int node = bfs.pollFirst();
            if (node == destination) {
                return true;
            }
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int child : graph.get(node)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    bfs.add(child);
                }
            }
        }
        return false;
    }
}

// time O(V + E)
// space O(V + E)