class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long pivot = left + (right - left) / 2;
            if (pivot * pivot == num)
                return true;
            if (pivot * pivot < num) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return false;
    }
}