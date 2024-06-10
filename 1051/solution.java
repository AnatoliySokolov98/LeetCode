class Solution {
    public int heightChecker(int[] heights) {
        int maximum = 0;
        for (int num : heights) {
            maximum = Math.max(maximum, num);
        }
        int[] counts = new int[maximum + 1];
        for (int num : heights) {
            counts[num]++;
        }
        int res = 0;
        int h = 0;
        int c = 0;
        while (h < heights.length && c < counts.length) {
            if (counts[c] == 0) {
                c++;
                continue;
            }
            if (heights[h] != c) {
                res++;
            }
            counts[c]--;
            h++;
        }
        return res;
    }
}

// time O(n + k)
// space O(k)