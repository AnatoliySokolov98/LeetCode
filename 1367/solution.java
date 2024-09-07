class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse(root, head);
    }

    private boolean traverse(TreeNode curr, ListNode head) {
        if (curr == null) {
            return false;
        }
        return dfs(curr, head) || traverse(curr.left, head) || traverse(curr.right, head);
    }

    private boolean dfs(TreeNode curr, ListNode currNode) {
        if (curr == null || curr.val != currNode.val) {
            return false;
        }
        if (currNode.next == null) {
            return true;
        }
        return dfs(curr.left, currNode.next) || dfs(curr.right, currNode.next);
    }
}

// time O(n * min(2^M, N))
// space O(H)