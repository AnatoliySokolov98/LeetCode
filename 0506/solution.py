class Solution:
    def findRelativeRanks(self, score: list[int]) -> list[str]:
        S = len(score)
        sorted_scores = sorted([(v, i) for i, v in enumerate(score)], reverse=True)
        res = ["1"] * S
        medals = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        for i in range(S):
            if i <= 2:
                res[sorted_scores[i][1]] = medals[i]
            else:
                res[sorted_scores[i][1]] = str(i + 1)
        return res
