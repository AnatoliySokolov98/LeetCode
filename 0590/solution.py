class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: "Node") -> list[int]:
        post = []
        stack = []
        if root:
            stack.append(root)
        while stack:
            node = stack.pop()
            post.append(node.val)
            for child in node.children:
                stack.append(child)
        return post[::-1]
