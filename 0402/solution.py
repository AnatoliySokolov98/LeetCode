class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            while k > 0 and stack and n < stack[-1]:
                stack.pop()
                k -= 1
            stack.append(n)
        print(stack)
        while k > 0:
            stack.pop()
            k -= 1

        curr = 0
        while curr < len(stack) and stack[curr] == "0":
            curr += 1
        if not stack or curr >= len(stack):
            return "0"
        return "".join(stack[curr:])
