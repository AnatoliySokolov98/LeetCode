
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
    public String smallestFromLeaf(TreeNode root) {
        return traverse(root, "");
    }

    private String traverse(TreeNode node, String curr) {
        String newWord = (char) (node.val + 'a') + curr;
        if (node.left == null && node.right == null) {
            return newWord;
        }

        if (node.left == null) {
            return traverse(node.right, newWord);
        }

        if (node.right == null) {
            return traverse(node.left, newWord);
        }

        String left = traverse(node.left, newWord);
        String right = traverse(node.right, newWord);

        if (left.compareTo(right) < 0) {
            return left;
        }

        else {
            return right;
        }
    }
}

// time O(n^2)
// space O(n)