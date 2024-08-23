from functools import reduce


class Solution:
    def fractionAddition(self, expression: str) -> str:
        # Function to find the greatest common divisor
        def gcd(x, y):
            if y == 0:
                return x
            return gcd(y, x % y)

        # Extracting the fractions from the expression
        fractions = []
        i, n = 0, len(expression)
        while i < n:
            start = i
            if expression[i] in "+-":
                i += 1
            while i < n and expression[i] not in "+-":
                i += 1
            fractions.append(expression[start:i])

        # Splitting the numerators and denominators
        numerators = []
        denominators = []
        for fraction in fractions:
            num, denom = map(int, fraction.split("/"))
            numerators.append(num)
            denominators.append(denom)

        # Calculate the common denominator
        common_denominator = reduce(lambda x, y: x * y // gcd(x, y), denominators)

        # Adjust numerators according to the common denominator and sum them up
        total_numerator = sum(
            num * (common_denominator // denom)
            for num, denom in zip(numerators, denominators)
        )

        # Reduce the fraction
        common_divisor = gcd(abs(total_numerator), common_denominator)
        total_numerator //= common_divisor
        common_denominator //= common_divisor

        # Return the result as a string
        return f"{total_numerator}/{common_denominator}"
