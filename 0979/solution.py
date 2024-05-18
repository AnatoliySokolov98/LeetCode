from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        def traverse(node):
            if not node:
                return 0, 0
            lcoins, lmoves = traverse(node.left)
            rcoins, rmoves = traverse(node.right)
            moves = abs(lcoins) + abs(rcoins)
            coins = lcoins + rcoins + node.val - 1
            return coins, moves + lmoves + rmoves

        return traverse(root)[1]
