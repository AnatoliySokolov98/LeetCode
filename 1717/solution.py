class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        res = 0
        stack = []
        goodVal = "ab" if x > y else "ba"
        firstChar, secondChar = goodVal
        small = min(x, y)
        big = max(x, y)

        def calculate_remaining_stack(stack):
            nonlocal res
            one, two = 0, 0
            for char in stack:
                if char == "a":
                    one += 1
                else:
                    two += 1
            res += min(one, two) * small

        for char in s:
            if char not in "ab":
                calculate_remaining_stack(stack)
                stack = []
            elif char == secondChar and stack and stack[-1] == firstChar:
                stack.pop()
                res += big
            else:
                stack.append(char)

        if stack:
            calculate_remaining_stack(stack)
        return res
