import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int[] res = { -1, Integer.MAX_VALUE };
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int dist = edge[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[] { y, dist });
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[] { x, dist });
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            heap.add(new int[] { 0, i });
            while (!heap.isEmpty()) {
                int[] curr = heap.poll();
                int dist = curr[0];
                int node = curr[1];
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                if (graph.containsKey(node)) {
                    for (int[] child : graph.get(node)) {
                        int childNode = child[0];
                        int childDistance = child[1];
                        if (!visited.contains(childNode) && dist + childDistance <= distanceThreshold) {
                            heap.add(new int[] { dist + childDistance, childNode });
                        }
                    }
                }
            }
            if (res[1] >= visited.size() - 1) {
                res = new int[] { i, visited.size() - 1 };
            }
        }
        return res[0];
    }
}

// time O(E + V*E^2log(E))
// space O(V + E^2)