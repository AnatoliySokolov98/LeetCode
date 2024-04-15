from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = 0

        def root_to_leaf(node, val):
            curr = node.val + val
            if not node.left and not node.right:
                nonlocal res
                res += curr
            curr *= 10
            if node.left:
                root_to_leaf(node.left, curr)
            if node.right:
                root_to_leaf(node.right, curr)

        root_to_leaf(root, 0)
        return res
