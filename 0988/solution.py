from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        def traverse(node, curr):
            val = chr(ord("a") + node.val)
            if not node.left and not node.right:
                return val + curr
            if not node.left:
                return traverse(node.right, val + curr)
            if not node.right:
                return traverse(node.left, val + curr)
            return min(
                traverse(node.left, val + curr), traverse(node.right, val + curr)
            )

        return traverse(root, "")
