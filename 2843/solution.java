class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            String curr = Integer.toString(i);
            if (isSymmetric(curr)) {
                res++;
            }
        }
        return res;
    }

    private boolean isSymmetric(String num) {
        if (num.length() % 2 == 1) {
            return false;
        }
        int half = num.length() / 2;
        int total = 0;
        for (int i = 0; i < half; i++) {
            total += num.charAt(i);
            total -= num.charAt(i + half);
        }
        return total == 0;
    }
}

// time O(n)
// space O(1)