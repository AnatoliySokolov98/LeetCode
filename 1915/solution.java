class Solution {
    public long wonderfulSubstrings(String word) {
        int[] counts = new int[(int) Math.pow(2, 10)];
        long res = 0;
        int mask = 0;
        counts[0] = 1;
        for (int i = 0; i < word.length(); i++) {
            mask ^= (1 << ((int) word.charAt(i) - 'a'));
            res += counts[mask];
            for (int j = 0; j < 10; j++) {
                int newMask = mask ^ (1 << j);
                res += counts[newMask];
            }
            counts[mask]++;
        }
        return res;
    }
}

// time O(n)
// space O(2**chars)