from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def delNodes(
        self, root: Optional[TreeNode], to_delete: list[int]
    ) -> list[TreeNode]:
        nodes = []
        bad_nodes = set(to_delete)

        def traverse(node, hasParent):
            if not node:
                return None
            if not hasParent and node.val not in bad_nodes:
                nodes.append(node)
            if node.val in bad_nodes:
                traverse(node.left, False)
                traverse(node.right, False)
                return None
            else:
                node.left = traverse(node.left, True)
                node.right = traverse(node.right, True)
            return node

        traverse(root, False)
        return nodes
