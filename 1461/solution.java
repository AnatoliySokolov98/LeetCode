import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int parent = manager[i];
            if (parent == -1) {
                continue;
            }
            graph.put(parent, graph.getOrDefault(parent, new ArrayList<Integer>()));
            graph.get(parent).add(i);
        }
        List<int[]> bfs = new ArrayList<>();
        bfs.add(new int[] { headID, 0 });

        int res = 0;
        while (!bfs.isEmpty()) {
            int[] curr = bfs.removeLast();
            int node = curr[0];
            int time = curr[1];
            res = Math.max(res, time);
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    bfs.add(new int[] { child, time + informTime[node] });
                }
            }
        }
        return res;
    }
}