from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        if root.val <= 1:
            return root.val
        left = self.evaluateTree(root.left)
        right = self.evaluateTree(root.right)
        if root.val == 3:
            return left and right
        else:
            return left or right
