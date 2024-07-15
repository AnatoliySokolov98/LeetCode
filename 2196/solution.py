from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def createBinaryTree(self, descriptions: list[list[int]]) -> Optional[TreeNode]:
        graph = {}
        children = set()
        for x, y, left in descriptions:
            if x not in graph:
                graph[x] = TreeNode(x)
            if y not in graph:
                graph[y] = TreeNode(y)
            if left:
                graph[x].left = graph[y]
            else:
                graph[x].right = graph[y]
            children.add(y)
        for key in graph:
            if key not in children:
                return graph[key]
