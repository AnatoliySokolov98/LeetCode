from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def addOneRow(
        self, root: Optional[TreeNode], val: int, depth: int
    ) -> Optional[TreeNode]:
        if depth == 1:
            return TreeNode(val, root, None)

        def traverse(node, val, level, depth):
            if not node:
                return
            if level == depth - 1:
                left, right = node.left, node.right
                node.left = TreeNode(val, left, None)
                node.right = TreeNode(val, None, right)
            else:
                traverse(node.left, val, level + 1, depth)
                traverse(node.right, val, level + 1, depth)

        traverse(root, val, 1, depth)
        return root
