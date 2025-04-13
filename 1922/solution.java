class Solution {
    public int countGoodNumbers(long n) {
        long MOD = 1_000_000_007;
        long even = (n + 1) / 2;
        long odd = n / 2;
        return (int) (fastPow(5, even, MOD) * fastPow(4, odd, MOD) % MOD);

    }

    private long fastPow(long base, long exponent, long MOD) {
        long res = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base)  % MOD;
            exponent >>= 1;
        }
        return res;
    }
}

// time O(log(n))
// space O(1)