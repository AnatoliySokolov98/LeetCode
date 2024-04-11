class Solution:
    def isValid(self, s: str) -> bool:
        opens = []
        for char in s:
            if char == "(" or char == "{" or char == "[":
                opens.append(char)

            else:
                if char == "}":
                    if not opens or opens.pop() != "{":
                        return False
                if char == "]":
                    if not opens or opens.pop() != "[":
                        return False
                if char == ")":
                    if not opens or opens.pop() != "(":
                        return False

        return True if opens == [] else False

        # timeO(n)
        # space O(n)
