import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> badNodes = new HashSet<>();
        for (int val : to_delete) {
            badNodes.add(val);
        }
        List<TreeNode> res = new ArrayList<>();
        traverse(root, false, badNodes, res);
        return res;
    }

    private TreeNode traverse(TreeNode node, boolean hasParent, Set<Integer> badNodes, List<TreeNode> res) {
        if (node == null) {
            return null;
        }

        if (!badNodes.contains(node.val)) {
            if (!hasParent) {
                res.add(node);
            }
            node.left = traverse(node.left, true, badNodes, res);
            node.right = traverse(node.right, true, badNodes, res);
        } else {
            traverse(node.left, false, badNodes, res);
            traverse(node.right, false, badNodes, res);
            return null;
        }
        return node;
    }
}

// time O(m + n)
// space O(m + h)
