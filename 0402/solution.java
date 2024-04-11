class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !builder.isEmpty() && builder.charAt(builder.length() - 1) > num.charAt(i)) {
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            if (!builder.isEmpty() || num.charAt(i) != '0') {
                builder.append(num.charAt(i));
            }
        }
        return k >= builder.length() ? "0" : builder.substring(0, builder.length() - k);
    }
}

// time O(n)
// space O(n)