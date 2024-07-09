class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int currTime = 0;
        for (int[] cust : customers) {
            if (currTime < cust[0]) {
                currTime = cust[0];
            }
            currTime += cust[1];
            total += currTime - cust[0];
        }
        return total / customers.length;
    }
}

// time O(n)
// space O(1)