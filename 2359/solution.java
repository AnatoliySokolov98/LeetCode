import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> nodeOneNodes = new HashMap<>();
        Map<Integer, Integer> nodeTwoNodes = new HashMap<>();
        computeDistances(edges, node1, nodeOneNodes);
        computeDistances(edges, node2, nodeTwoNodes);
        int node = -1;
        int dist = Integer.MAX_VALUE;
        for (var entry : nodeOneNodes.entrySet()) {
            int key = entry.getKey();
            int nodeOneValue = entry.getValue();
            int nodeTwoValue = nodeTwoNodes.getOrDefault(key, Integer.MAX_VALUE);
            int maxDist = Math.max(nodeOneValue, nodeTwoValue);
            if (maxDist < dist || (dist == maxDist && key < node)) {
                dist = maxDist;
                node = key;
            }
        }
        return node;
    }

    private void computeDistances(int[] edges, int start, Map<Integer, Integer> distances) {
        int distance = 0;
        while (start != -1 && !distances.containsKey(start)) {
            distances.put(start, distance++);
            start = edges[start];
        }
    }
}

// time O(n)
// space O(n)
