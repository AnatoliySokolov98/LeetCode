import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int[] depth1 = bfsDepth(tree1, 0);
        int[] depth2 = bfsDepth(tree2, 0);

        int[] parity1 = countParity(depth1);
        int[] parity2 = countParity(depth2);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (depth1[i] % 2 == 0) {
                answer[i] = parity1[0] + Math.max(parity2[0], parity2[1]);
            } else {
                answer[i] = parity1[1] + Math.max(parity2[0], parity2[1]);
            }
        }
        return answer;
    }

    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private int[] bfsDepth(List<List<Integer>> tree, int root) {
        int[] depth = new int[tree.size()];
        Arrays.fill(depth, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        depth[root] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (depth[neighbor] == -1) {
                    depth[neighbor] = depth[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return depth;
    }

    private int[] countParity(int[] depth) {
        int[] count = new int[2];
        for (int d : depth) {
            count[d % 2]++;
        }
        return count;
    }
}

// O(m + n)
// O(m + n)
