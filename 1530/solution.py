from collections import defaultdict, deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        leaves = set()
        graph = defaultdict(list)
        root.val = 0
        uuid = 1

        def traverse(node):
            nonlocal uuid
            if node.left:
                node.left.val = uuid
                uuid += 1
                graph[node.val].append(node.left.val)
                graph[node.left.val].append(node.val)
                traverse(node.left)
            if node.right:
                node.right.val = uuid
                uuid += 1
                graph[node.val].append(node.right.val)
                graph[node.right.val].append(node.val)
                traverse(node.right)
            if not node.left and not node.right:
                leaves.add(node.val)

        traverse(root)
        res = 0
        for node in leaves:
            visited = set()
            bfs = deque([[node, 0]])
            visited.add(node)
            while bfs:
                curr, dist = bfs.popleft()
                if dist == distance:
                    continue
                for child in graph[curr]:
                    if child not in visited:
                        visited.add(child)
                        if child in leaves:
                            res += 1
                        bfs.append([child, dist + 1])
        return res // 2
