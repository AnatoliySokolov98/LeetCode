/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */
abstract class GuessGame {
    abstract int guess(int p);
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int p = l + (int) Math.floor((r - l) / 2);
            int res = guess(p);
            if (res == 0) {
                return p;
            }
            if (res == 1) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return -1;
    }
}