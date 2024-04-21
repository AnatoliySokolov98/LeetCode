class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                int total = (carry + (b.charAt(j) - '0')) % 2;
                carry = (carry + (b.charAt(j) - '0')) / 2;
                builder.append((char) (total + '0'));
                j--;
            }

            else if (j < 0) {
                int total = (carry + (a.charAt(i) - '0')) % 2;
                carry = (carry + (a.charAt(i) - '0')) / 2;
                builder.append((char) (total + '0'));
                i--;
            } else {
                int total = (carry + (a.charAt(i) - '0') + (b.charAt(j) - '0')) % 2;
                carry = (carry + (a.charAt(i) - '0') + (b.charAt(j) - '0')) / 2;
                builder.append((char) (total + '0'));
                i--;
                j--;
            }
        }

        if (carry == 1)
            builder.append('1');
        return builder.reverse().toString();
    }
}