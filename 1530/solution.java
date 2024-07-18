import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int uuid = 1;
    Set<Integer> leaves = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int countPairs(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        root.val = 0;
        traverse(root);
        int res = 0;
        for (int leaf : leaves) {
            Deque<int[]> bfs = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            bfs.add(new int[] { leaf, 0 });
            visited.add(leaf);
            while (!bfs.isEmpty()) {
                int[] curr = bfs.pollFirst();
                int node = curr[0];
                int dist = curr[1];
                if (dist == distance) {
                    continue;
                }
                for (int child : graph.get(node)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        if (leaves.contains(child)) {
                            res++;
                        }
                        bfs.add(new int[] { child, dist + 1 });
                    }
                }
            }
        }
        return res / 2;
    }

    private void traverse(TreeNode node) {
        if (node.left != null) {
            node.left.val = uuid++;
            graph.computeIfAbsent(node.val, k -> new ArrayList<Integer>()).add(node.left.val);
            graph.computeIfAbsent(node.left.val, k -> new ArrayList<Integer>()).add(node.val);
            traverse(node.left);
        }
        if (node.right != null) {
            node.right.val = uuid++;
            graph.computeIfAbsent(node.val, k -> new ArrayList<Integer>()).add(node.right.val);
            graph.computeIfAbsent(node.right.val, k -> new ArrayList<Integer>()).add(node.val);
            traverse(node.right);
        }

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
    }
}

// time O(N * D^2)
// space O(N)