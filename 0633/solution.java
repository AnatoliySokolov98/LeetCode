class Solution {
    public boolean judgeSquareSum(int c) {
        int root = (int) Math.sqrt(c);
        for (int a = 0; a <= root; a++) {
            double b = Math.sqrt(c - (a * a));
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}

// time O(sqrt(c)log(c))
// space O(1)