class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(left + 1, right, s) || check(left, right - 1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean check(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}