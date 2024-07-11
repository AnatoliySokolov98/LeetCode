class Solution:
    def reverseParentheses(self, s: str) -> str:
        locs = {}
        stack = []
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            elif s[i] == ")":
                locs[stack[-1]] = i
                locs[i] = stack[-1]
                stack.pop()
        res = []
        direction = 1
        curr = 0
        print(locs)
        while 0 <= curr < len(s):
            if curr in locs:
                direction *= -1
                curr = locs[curr] + direction
            else:
                res.append(s[curr])
                curr += direction
        return "".join(res)
