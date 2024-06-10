class Solution:
    def heightChecker(self, heights: list[int]) -> int:
        inorder = [0] * max(heights)
        for num in heights:
            inorder[num - 1] += 1
        i = 0
        j = 0
        res = 0
        while i < len(inorder) and j < len(heights):
            if inorder[i] == 0:
                i += 1
                continue
            if heights[j] != i + 1:
                res += 1
            inorder[i] -= 1
            j += 1
        return res
