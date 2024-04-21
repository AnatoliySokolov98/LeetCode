class Solution {
    public int minSwaps(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                left++;
            else {
                if (right == left) {
                    res++;
                    left++;
                } else {
                    right++;
                }
            }
        }
        return res;
    }
}