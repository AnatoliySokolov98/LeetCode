from functools import cache


class Solution:
    def minHeightShelves(self, books: list[list[int]], shelfWidth: int) -> int:
        @cache
        def dp(i):
            if i == len(books):
                return 0
            res = float("inf")
            height = 0
            width = 0
            for j in range(i, len(books)):
                width += books[j][0]
                height = max(height, books[j][1])
                if width > shelfWidth:
                    break
                res = min(res, height + dp(j + 1))
            return res

        return dp(0)
