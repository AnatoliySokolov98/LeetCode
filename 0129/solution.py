from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def root_to_leaf(node, val):
            if not node:
                return 0
            curr = node.val + val * 10
            if not node.left and not node.right:
                return curr
            return root_to_leaf(node.left, curr) + root_to_leaf(node.right, curr)

        return root_to_leaf(root, 0)
        return res

        # time O(n)
        # space O(n)
