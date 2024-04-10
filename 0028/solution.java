class Solution {
    public int strStr(String h, String n) {
        int H = h.length();
        int N = n.length();
        int MOD = 1_000_000_007;
        if (N > H)
            return -1;

        long[] powers = new long[H];
        final int PRIME = 131;
        powers[0] = 1;
        for (int i = 1; i < H; i++) {
            powers[i] = ((long) powers[i - 1] * PRIME) % MOD;
        }

        long[] prefixes = new long[H];
        prefixes[0] = h.charAt(0);
        for (int i = 1; i < H; i++) {
            prefixes[i] = (prefixes[i - 1] + (h.charAt(i)) * powers[i]) % MOD;
        }

        long needle_hash = n.charAt(0);
        for (int i = 1; i < N; i++) {
            needle_hash = (needle_hash + (n.charAt(i)) * powers[i]) % MOD;
        }

        for (int i = 0; i <= H - N; i++) {
            int end = i + N - 1;
            long haystack_hash = prefixes[end];
            if (i > 0) {
                haystack_hash = (haystack_hash - prefixes[i - 1] + MOD) % MOD;
            }

            if (haystack_hash == (needle_hash * powers[i]) % MOD) {
                return i;
            }
        }

        return -1;
    }
}
