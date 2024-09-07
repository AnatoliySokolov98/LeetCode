from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def dfs(node, list_node):
            if not node or node.val != list_node.val:
                return False
            if not list_node.next:
                return True
            return dfs(node.left, list_node.next) or dfs(node.right, list_node.next)

        def traverse(node):
            if not node:
                return False
            return dfs(node, head) or traverse(node.left) or traverse(node.right)

        return traverse(root)
