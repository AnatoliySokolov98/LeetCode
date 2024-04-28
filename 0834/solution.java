import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, List<Integer>> tree;
    int[] counts;
    int[] distances;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) {
            return new int[] { 0 };
        }
        N = n;
        counts = new int[n];
        distances = new int[n];
        tree = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            tree.putIfAbsent(x, new ArrayList<Integer>());
            tree.putIfAbsent(y, new ArrayList<Integer>());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        distances[0] = getCounts(0, -1);
        getDistances(0, -1);
        return distances;
    }

    private int getCounts(int node, int parent) {
        int distance = 0;
        for (int child : tree.get(node)) {
            if (child != parent) {
                distance += getCounts(child, node) + counts[child];
                counts[node] += counts[child];
            }
        }
        counts[node]++;
        return distance;
    }

    private void getDistances(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                distances[child] = distances[node] - counts[child] + (N - counts[child]);
                getDistances(child, node);
            }
        }
    }
}

// time O(n)
// space O(n)