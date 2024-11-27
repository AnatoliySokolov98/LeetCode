import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize graph as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        // Result array to store shortest distances for each query
        int[] res = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // Add the directed edge to the graph
            graph.get(from).add(to);

            // BFS to find the shortest path from node 0 to node (n - 1)
            res[i] = bfsShortestPath(graph, n);
        }

        return res;
    }

    private int bfsShortestPath(Map<Integer, List<Integer>> graph, int n) {
        // Queue to perform BFS; stores pairs of (node, distance)
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 }); // Start from node 0 with distance 0

        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int node = current[0];
            int distance = current[1];

            // If we reach the target node (n - 1), return the distance
            if (node == n - 1) {
                return distance;
            }

            // Add all unvisited neighbors to the queue
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[] { neighbor, distance + 1 });
                }
            }
        }
        // If no path exists to node (n - 1), return -1
        return -1;
    }
}

// time O(m*(n + m))
// space O(n + m)