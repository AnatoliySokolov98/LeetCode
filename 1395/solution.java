class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            int l = 0;
            int r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    l++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    r++;
                }
            }
            res += l * r;
            res += (i - l) * (rating.length - i - 1 - r);
        }
        return res;
    }
}

// time O(n^2)
// space O(1)