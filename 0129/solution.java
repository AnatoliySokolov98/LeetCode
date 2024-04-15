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
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        int newVal = val * 10 + node.val;

        if (node.left == null && node.right == null) {
            return newVal;
        }
        return traverse(node.left, newVal) + traverse(node.right, newVal);
    }
}