
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
    int total = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return total;
    }

    private void traverse(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        int newVal = val * 10 + node.val;

        if (node.left == null && node.right == null) {
            total += newVal;
        } else {
            traverse(node.left, newVal);
            traverse(node.right, newVal);
        }
    }
}

// time O(n)
// space O(depth)