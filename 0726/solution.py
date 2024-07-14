from collections import defaultdict


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack = [defaultdict(int)]
        i = 0
        while i < len(formula):
            if formula[i] == "(":
                stack.append(defaultdict(int))
                i += 1
            elif formula[i] == ")":
                i += 1
                start = i
                while i < len(formula) and formula[i].isdigit():
                    i += 1
                val = int(formula[start:i] or "1")
                curr = stack.pop()
                for key in curr:
                    stack[-1][key] += curr[key] * val
            else:
                start = i
                i += 1
                while i < len(formula) and formula[i].islower():
                    i += 1
                element = formula[start:i]
                start = i
                while i < len(formula) and formula[i].isdigit():
                    i += 1
                val = int(formula[start:i] or "1")
                stack[-1][element] += val

        result = ""
        for key in sorted(stack[-1].keys()):
            result += key
            if stack[-1][key] > 1:
                result += str(stack[-1][key])

        return result
