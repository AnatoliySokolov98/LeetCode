
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        traverse(root, val, depth, 1);
        return root;
    }

    private void traverse(TreeNode node, int val, int depth, int level) {
        if (node == null) {
            return;
        }

        if (level == depth - 1) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(val, left, null);
            node.right = new TreeNode(val, null, right);
        }

        else {
            traverse(node.left, val, depth, level + 1);
            traverse(node.right, val, depth, level + 1);
        }
    }
}

// time O(n)
// space O(depth)
