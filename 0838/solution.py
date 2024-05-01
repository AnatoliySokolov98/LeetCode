class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        res = list(dominoes)
        stack = []
        right_loc = float("-inf")
        for i, curr in enumerate(dominoes):
            if curr == ".":
                stack.append(i)
            elif curr == "R":
                while stack and right_loc != float("-inf"):
                    loc = stack.pop()
                    res[loc] = "R"
                stack = []
                right_loc = i
            else:
                while stack:
                    loc = stack.pop()
                    if right_loc == float("-inf"):
                        res[loc] = "L"
                    elif loc - right_loc < i - loc:
                        res[loc] = "R"
                    elif loc - right_loc > i - loc:
                        res[loc] = "L"
                right_loc = float("-inf")
        while stack and right_loc != float("-inf"):
            loc = stack.pop()
            res[loc] = "R"
        return "".join(res)
