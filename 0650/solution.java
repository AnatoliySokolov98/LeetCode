class Solution {
    public int minSteps(int n) {
        int res = 0;
        int root = (int) Math.ceil(Math.sqrt(n));
        int factor = 2;
        while (factor <= root) {
            while (n % factor == 0) {
                res += factor;
                n /= factor;
            }
            factor++;
        }

        return n > 1 ? res + n : res;
    }
}

// time O(sqrt(n)log(sqrt(n)))
// space O(1)
