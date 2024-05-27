class Node:
    """Node for Tree"""

    def __init__(self, L: int, R: int, vals=[0, 0, 0, 0], left=None, right=None):
        # value for node
        self.vals = vals
        # left bound of range
        self.L = L
        # right bound of range
        self.R = R
        # left child
        self.left = left
        # right child
        self.right = right


# [no left or right, no left, no right, both left and right]
class SegmentTree:
    """Segment Tree"""

    def __init__(self, nums: list[int]):
        self.root = self.builder(0, len(nums) - 1, nums)

    def builder(self, L: int, R: int, nums: list[int]) -> Node:
        """build the tree from an array"""
        # leaf node
        if L == R:
            return Node(L, R, [0, 0, 0, nums[L]])
        # recurse left and right and get node's value from children
        mid = (L + R) // 2
        left = self.builder(L, mid, nums)
        right = self.builder(mid + 1, R, nums)
        no_left_or_right = max(
            left.vals[1] + right.vals[0], left.vals[0] + right.vals[2]
        )
        no_left = max(left.vals[1] + right.vals[1], left.vals[0] + right.vals[3])
        no_right = max(left.vals[3] + right.vals[0], left.vals[2] + right.vals[2])
        both = max(left.vals[3] + right.vals[1], left.vals[2] + right.vals[3])
        return Node(L, R, [no_left_or_right, no_left, no_right, both], left, right)

    def update(self, index: int, val: int):
        """update a node"""
        self.update_helper(self.root, index, val)

    def update_helper(self, node: Node, index: int, val: int):
        """helper function for update"""
        # base case leaf node needs update
        if node.L == index and node.R == index:
            node.vals[3] = val
            return
        # otherwise find where to recurse and recurse
        mid = (node.L + node.R) // 2

        if node.L <= index <= mid:
            self.update_helper(node.left, index, val)
        else:
            self.update_helper(node.right, index, val)
        left = node.left
        right = node.right
        no_left_or_right = max(
            left.vals[1] + right.vals[0], left.vals[0] + right.vals[2]
        )
        no_left = max(left.vals[1] + right.vals[1], left.vals[0] + right.vals[3])
        no_right = max(left.vals[3] + right.vals[0], left.vals[2] + right.vals[2])
        both = max(left.vals[3] + right.vals[1], left.vals[2] + right.vals[3])
        node.vals = [no_left_or_right, no_left, no_right, both]


class Solution:
    def maximumSumSubsequence(self, nums: list[int], queries: list[list[int]]) -> int:
        MOD = 10**9 + 7
        sg = SegmentTree(nums)
        res = 0
        for idx, num in queries:
            sg.update(idx, num)
            res += max((sg.root.vals[3]), 0)
            res %= MOD
        return res


# time O(n + qlog(n))
# space O(n)
