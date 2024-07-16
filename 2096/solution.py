from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def getDirections(
        self, root: Optional[TreeNode], startValue: int, destValue: int
    ) -> str:
        curr = []
        paths = ["", ""]

        def traverse(node: Optional[TreeNode]):
            if not node:
                return

            if node.val == startValue:
                paths[0] = "".join(curr)
            if node.val == destValue:
                paths[1] = "".join(curr)

            if node.left:
                curr.append("L")
                traverse(node.left)
                curr.pop()

            if node.right:
                curr.append("R")
                traverse(node.right)
                curr.pop()

        traverse(root)
        i = 0
        while i < len(paths[0]) and i < len(paths[1]) and paths[0][i] == paths[1][i]:
            i += 1
        upward_steps = len(paths[0]) - i
        remaining_steps = paths[1][i:]
        return "U" * upward_steps + remaining_steps
