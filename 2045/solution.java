import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[][] dist = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = Integer.MAX_VALUE;
            dist[i][1] = Integer.MAX_VALUE;
        }
        dist[1][1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], currentTime = current[1];
            int nextTime = currentTime + time;
            int cycle = currentTime / change;

            if (cycle % 2 == 1) {
                int waitTime = change - (currentTime % change);
                nextTime += waitTime;
            }

            for (int neighbor : graph[node]) {
                if (dist[neighbor][0] == Integer.MAX_VALUE) {
                    dist[neighbor][0] = nextTime;
                    queue.offer(new int[] { neighbor, nextTime });
                } else if (dist[neighbor][0] < nextTime && dist[neighbor][1] == Integer.MAX_VALUE) {
                    dist[neighbor][1] = nextTime;
                    queue.offer(new int[] { neighbor, nextTime });
                }
            }
        }

        return dist[n][1];
    }
}

// time O(V + E)
// space O(V + E)