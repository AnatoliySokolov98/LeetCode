class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        res = []
        curr = []
        candidates.sort()

        def backtrack(index, total):
            if total < 0:
                return
            if total == 0:
                res.append(curr.copy())
                return

            if index >= len(candidates):
                return

            curr.append(candidates[index])
            backtrack(index + 1, total - candidates[index])
            curr.pop()

            while (
                index + 1 < len(candidates)
                and candidates[index + 1] == candidates[index]
            ):
                index += 1
            backtrack(index + 1, total)

        backtrack(0, target)
        return res

        # time O(2^n)
        # space O(n)stack O(n) curr array + output rounds to O(n)
