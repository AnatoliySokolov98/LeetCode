public class TreeNode {

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
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }

    public int traverse(TreeNode node, boolean isLeftChild) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null && isLeftChild) {
            return node.val;
        }

        return traverse(node.left, true) + traverse(node.right, false);
    }
}