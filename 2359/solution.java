import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> lefts = new HashMap<>();
        Map<Integer, Integer> rights = new HashMap<>();
        computeDistances(edges, node1, lefts);
        computeDistances(edges, node2, rights);
        int node = -1;
        int dist = Integer.MAX_VALUE;
        for (var entry : lefts.entrySet()) {
            int key = entry.getKey();
            int leftVal = entry.getValue();
            int rightVal = rights.getOrDefault(key, Integer.MAX_VALUE);
            int maxDist = Math.max(leftVal, rightVal);
            if (maxDist < dist || (dist == maxDist && key < node)) {
                dist = Math.max(leftVal, rightVal);
                node = key;
            }
        }
        return dist == Integer.MAX_VALUE ? -1 : node;
    }

    private void computeDistances(int[] edges, int start, Map<Integer, Integer> dist) {
        int distance = 0;
        while (start != -1 && !dist.containsKey(start)) {
            dist.put(start, distance++);
            start = edges[start];
        }
    }
}
