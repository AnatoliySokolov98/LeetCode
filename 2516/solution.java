class Solution {
    public int takeCharacters(String s, int k) {
        int[] leftCounts = new int[3];
        int[] rightCounts = new int[3];
        int r = s.length();
        while (rightCounts[0] < k || rightCounts[1] < k || rightCounts[2] < k) {
            r--;
            if (r < 0)
                return -1;
            rightCounts[s.charAt(r) - 'a']++;
        }
        int res = s.length() - r;
        for (int l = 0; l < s.length(); l++) {
            int leftChar = s.charAt(l) - 'a';
            leftCounts[leftChar]++;
            while (r < s.length()) {
                int rightChar = s.charAt(r) - 'a';
                if (rightCounts[rightChar] + leftCounts[rightChar] > k) {
                    rightCounts[rightChar]--;
                    r++;
                } else {
                    break;
                }
            }
            res = Math.min(res, l + 1 + s.length() - r);
        }
        return res;
    }
}

// time O(n)
// space O(1)