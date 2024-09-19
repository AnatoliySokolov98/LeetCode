class Solution:
    def diffWaysToCompute(self, expression: str) -> list[int]:
        def apply_op(a, b, op):
            if op == "+":
                return a + b
            elif op == "-":
                return a - b
            elif op == "*":
                return a * b

        def parse_expression(expression):
            nums, ops = [], []
            num = 0
            for i, c in enumerate(expression):
                if c.isdigit():
                    num = num * 10 + int(c)
                else:
                    nums.append(num)
                    ops.append(c)
                    num = 0
            nums.append(num)  # Append the last number
            return nums, ops

        # Recursively compute the possible results for the expression
        def solve(left, right):
            if (left, right) in memo:
                return memo[(left, right)]

            # Base case: if there is only one number, return it
            if left == right:
                return [nums[left]]

            results = []
            # Iterate over the operators in the current segment
            for i in range(left, right):
                # Recursively compute the results of the left and right subexpressions
                left_results = solve(left, i)
                right_results = solve(i + 1, right)

                # Combine the results of left and right subexpressions using the current operator
                for left_res in left_results:
                    for right_res in right_results:
                        results.append(apply_op(left_res, right_res, ops[i]))

            # Memoize the computed results for the current segment
            memo[(left, right)] = results
            return results

        nums, ops = parse_expression(expression)  # Parse the expression
        memo = {}  # Dictionary for memoization
        return solve(0, len(nums) - 1)  # Solve for the entire expression
