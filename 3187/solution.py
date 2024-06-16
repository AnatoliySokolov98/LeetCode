class Node:
    """Node for Tree"""

    def __init__(self, L: int, R: int, val=0, left=None, right=None):
        # value for node
        self.val = val
        # left bound of range
        self.L = L
        # right bound of range
        self.R = R
        # left child
        self.left = left
        # right child
        self.right = right


class SegmentTree:
    """Segment Tree"""

    def __init__(self, nums: list[int]):
        self.root = self.builder(0, len(nums) - 1, nums)

    def builder(self, L: int, R: int, nums: list[int]) -> Node:
        """build the tree from an array"""
        # leaf node
        if L == R:
            return Node(L, R, nums[L])
        # recurse left and right and get node's value from children
        mid = (L + R) // 2
        left = self.builder(L, mid, nums)
        right = self.builder(mid + 1, R, nums)
        return Node(L, R, left.val + right.val, left, right)

    def update(self, index: int, val: int) -> None:
        """update a node"""
        self.update_helper(self.root, index, val)

    def update_helper(self, node: Node, index: int, val: int) -> int:
        """helper function for update"""
        # base case leaf node needs update
        if node.L == index and node.R == index:
            node.val = val
            return
        # otherwise find where to recurse and recurse
        mid = (node.L + node.R) // 2

        if node.L <= index <= mid:
            self.update_helper(node.left, index, val)
        else:
            self.update_helper(node.right, index, val)
        node.val = node.left.val + node.right.val

    def query(self, L: int, R: int) -> int:
        """query the segment tree"""
        return self.query_helper(self.root, L, R)

    def query_helper(self, node, L: int, R: int) -> int:
        """helper function for query"""
        # case 1 node completely in query
        if node.L >= L and node.R <= R:
            return node.val
        # case 2 node and query are disjoint
        if node.L > R or node.R < L:
            return 0
        # case 3 node and query intersect
        return self.query_helper(node.left, L, R) + self.query_helper(node.right, L, R)


class Solution:
    def countOfPeaks(self, nums: list[int], queries: list[list[int]]) -> list[int]:
        peaks = [0] * len(nums)
        for i in range(1, len(nums) - 1):
            if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]:
                peaks[i] = 1
        sg = SegmentTree(peaks)
        res = []
        for t, x, y in queries:
            if t == 1:
                if x + 1 <= y - 1:
                    res.append(sg.query(x + 1, y - 1))
                else:
                    res.append(0)
            elif t == 2:
                nums[x] = y
                if x - 1 > 0:
                    peak = nums[x - 2] < nums[x - 1] and nums[x - 1] > nums[x]
                    if peaks[x - 1] != peak:
                        sg.update(x - 1, peak)
                        peaks[x - 1] = peak
                if x > 0 and x < len(nums) - 1:
                    peak = nums[x - 1] < nums[x] and nums[x] > nums[x + 1]
                    if peaks[x] != peak:
                        sg.update(x, peak)
                        peaks[x] = peak
                if x + 1 < len(nums) - 1:
                    peak = nums[x + 2] < nums[x + 1] and nums[x + 1] > nums[x]
                    if peaks[x + 1] != peak:
                        sg.update(x + 1, peak)
                        peaks[x + 1] = peak
        return res
        # time O(n + qlogn)
        # space O(n)
