class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        prefix = strs[0]
        for i in range(1, len(strs)):
            new_prefix = []
            for j in range(len(strs[i])):
                if j >= len(prefix) or strs[i][j] != prefix[j]:
                    break
                else:
                    new_prefix.append(strs[i][j])
            prefix = "".join(new_prefix)
        return prefix
