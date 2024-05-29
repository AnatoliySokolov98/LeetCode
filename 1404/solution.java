class Solution {
    public int numSteps(String s) {
        int res = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int curr = (int) (s.charAt(i) - '0') + carry;
            if (curr == 2) {
                res += 1;
                carry = 1;
            } else if (curr == 1) {
                carry = 1;
                res += 2;
            } else {
                carry = 0;
                res += 1;
            }
        }
        return res + carry;
    }
}

// time O(n)
// space O(1)
