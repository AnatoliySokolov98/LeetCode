class Solution:
    def shortestPalindrome(self, s: str) -> str:
        POW = 1
        prime = 7
        MOD = 10**9 + 7
        forward_hash = 0
        reverse_hash = 0
        palindrome_end_index = -1
        n = len(s)

        # Calculate rolling hashes and find the longest palindromic prefix
        for i in range(n):
            current_char_value = ord(s[i])

            # Update forward hash
            forward_hash = (forward_hash + current_char_value * POW) % MOD

            # Update reverse hash using pow for base powers
            reverse_hash = (reverse_hash * prime + current_char_value) % MOD

            # If forward and reverse hashes match, update palindrome end index
            if forward_hash == reverse_hash:
                palindrome_end_index = i
            POW = (POW * prime) % MOD
        # Find the remaining suffix after the longest palindromic prefix
        suffix = s[palindrome_end_index + 1 :]

        # Reverse the remaining suffix and prepend it to the original string
        reversed_suffix = suffix[::-1]
        return reversed_suffix + s
