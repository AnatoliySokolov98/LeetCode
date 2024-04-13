class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        long res = 0; // Changed to long to prevent overflow
        while (l <= r) {
            int p = l + (r - l) / 2;
            long squared = (long) p * p; // Cast p to long before multiplication
            if (squared <= x) {
                res = p;
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return (int) res; // Casting back to int as the final answer is within int range
    }
}
