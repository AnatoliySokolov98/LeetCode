class Solution {
    private static final String[] lessThanTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine" };
    private static final String[] lessThanTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] lessThanHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };
    private static final int MIL = 1_000_000;
    private static final int BIL = 1_000_000_000;
    private StringBuilder res;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        res = new StringBuilder();
        makeNumber(num);
        return res.toString().trim();
    }

    private void makeNumber(int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            res.append(lessThanTen[num]).append(" ");
        } else if (num < 20) {
            res.append(lessThanTwenty[num - 10]).append(" ");
        } else if (num < 100) {
            res.append(lessThanHundred[num / 10]).append(" ");
            makeNumber(num % 10);
        } else if (num < 1000) {
            res.append(lessThanTen[num / 100]).append(" Hundred ");
            makeNumber(num % 100);
        } else if (num < MIL) {
            makeNumber(num / 1000);
            res.append("Thousand ");
            makeNumber(num % 1000);
        } else if (num < BIL) {
            makeNumber(num / MIL);
            res.append("Million ");
            makeNumber(num % MIL);
        } else {
            makeNumber(num / BIL);
            res.append("Billion ");
            makeNumber(num % BIL);
        }
    }
}

// time O(1)
// space O(1)