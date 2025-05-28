import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;

        Map<Integer, List<Integer>> tree1 = buildTree(edges1, n);
        Map<Integer, List<Integer>> tree2 = buildTree(edges2, m);

        int[] result = new int[n];
        int maxTree2Reach = 0;

        for (int i = 0; i < m; i++) {
            maxTree2Reach = Math.max(maxTree2Reach, bfsCount(i, tree2, k - 1));
        }

        for (int i = 0; i < n; i++) {
            result[i] = bfsCount(i, tree1, k) + maxTree2Reach;
        }

        return result;
    }

    private Map<Integer, List<Integer>> buildTree(int[][] edges, int size) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < size; i++)
            tree.put(i, new ArrayList<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        return tree;
    }

    private int bfsCount(int start, Map<Integer, List<Integer>> tree, int maxDist) {
        if (maxDist < 0)
            return 0;

        boolean[] visited = new boolean[tree.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        int count = 1, dist = 0;

        while (!queue.isEmpty() && dist++ < maxDist) {
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (int neighbor : tree.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

// time O(n^2 + m^2)
// space O(n + m)
