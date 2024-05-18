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
    public int distributeCoins(TreeNode root) {
        return traverse(root)[0];
    }

    private int[] traverse(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] leftInfo = traverse(node.left);
        int leftMoves = leftInfo[0];
        int leftCoins = leftInfo[1];
        int[] rightInfo = traverse(node.right);
        int rightMoves = rightInfo[0];
        int rightCoins = rightInfo[1];
        int currMoves = Math.abs(leftCoins) + Math.abs(rightCoins);
        int totalMoves = leftMoves + rightMoves + currMoves;
        int currCoins = leftCoins + rightCoins + node.val - 1;
        return new int[] { totalMoves, currCoins };
    }
}

// time O(n)
// space O(n)