class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            String curr = num.substring(i, i + 3);
            if (curr.charAt(0) == curr.charAt(1) && curr.charAt(1) == curr.charAt(2)) {
                if (res.length() == 0 || curr.charAt(0) > res.charAt(0)) {
                    res = curr;
                }
            }
        }
        return res;
    }
}