class Solution {
    public String shortestPalindrome(String s) {
        long pow = 1;
        int prime = 7;
        int MOD = 1_000_000_007;
        long forwardHash = 0;
        long reverseHash = 0;
        int palindromeEndIndex = -1;
        int n = s.length();

        // Calculate rolling hashes and find the longest palindromic prefix
        for (int i = 0; i < n; i++) {
            int currentCharValue = s.charAt(i);
            forwardHash = (forwardHash + currentCharValue * pow) % MOD;

            // Update reverse hash using pow for base powers
            reverseHash = (reverseHash * prime + currentCharValue) % MOD;

            // If forward and reverse hashes match, update palindrome end index
            if (forwardHash == reverseHash) {
                palindromeEndIndex = i;
            }
            pow = (pow * prime) % MOD;
        }

        // Find the remaining suffix after the longest palindromic prefix
        String suffix = s.substring(palindromeEndIndex + 1);

        // Reverse the remaining suffix and prepend it to the original string
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        return reversedSuffix + s;
    }
}

// time O(1)
// space O(n)