class Solution:
    def minOperations(self, logs: list[str]) -> int:
        level = 0
        for log in logs:
            if log == "../":
                level = max(0, level - 1)
            elif log == "./":
                continue
            else:
                level += 1
        return level
