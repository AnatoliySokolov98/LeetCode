class Trie:
    def __init__(self):
        self.children = {}
        self.end = False


class Solution:
    def minExtraChar(self, s: str, dictionary: list[str]) -> int:
        root = Trie()
        for word in dictionary:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = Trie()
                node = node.children[char]
            node.end = True

        visited = {}

        def dp(index):
            if index == len(s):
                return 0
            if index in visited:
                return visited[index]
            res = 1 + dp(index + 1)

            node = root
            for i in range(index, len(s)):
                if s[i] not in node.children:
                    break
                node = node.children[s[i]]
                if node.end:
                    res = min(res, dp(i + 1))
                if res == 0:
                    break
            visited[index] = res
            return res

        return dp(0)

    # time O(d + s^2)
    # space O(d + s)
