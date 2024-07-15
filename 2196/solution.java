import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> graph = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] node : descriptions) {
            int parent = node[0];
            int child = node[1];
            boolean isLeft = node[2] == 1;
            if (!graph.containsKey(parent)) {
                graph.put(parent, new TreeNode(parent));
            }
            if (!graph.containsKey(child)) {
                graph.put(child, new TreeNode(child));
            }
            children.add(child);
            if (isLeft) {
                graph.get(parent).left = graph.get(child);
            } else {
                graph.get(parent).right = graph.get(child);
            }
        }
        for (int key : graph.keySet()) {
            if (!children.contains(key)) {
                return graph.get(key);
            }
        }
        return null;
    }
}

// time O(n)
// space O(n)