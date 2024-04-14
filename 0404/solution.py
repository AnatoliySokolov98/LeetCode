from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        def traverse(node, isLeft):
            if not node:
                return 0
            if not node.left and not node.right and isLeft:
                return node.val
            left = traverse(node.left, True)
            right = traverse(node.right, False)
            return left + right

        return traverse(root, False)
