from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> list[int]:
        res = []

        def traverse(node):
            if not node:
                return
            traverse(node.left)
            res.append(node.val)
            traverse(node.right)

        traverse(root)
        return res

        # time O(n)
        # space O(n)
