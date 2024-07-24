import java.util.Arrays;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Tuple[] pairs = new Tuple[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Tuple(nums[i], i, mapNumber(nums[i], mapping));
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a.mappedNum == b.mappedNum) {
                return a.index - b.index;
            } else {
                return a.mappedNum - b.mappedNum;
            }
        });

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pairs[i].originalNum;
        }
        return res;
    }

    private int mapNumber(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }

        int res = 0;
        int place = 1;
        while (num > 0) {
            int digit = num % 10;
            res += mapping[digit] * place;
            num /= 10;
            place *= 10;
        }
        return res;
    }
}

class Tuple {
    int originalNum;
    int index;
    int mappedNum;

    Tuple(int originalNum, int index, int mappedNum) {
        this.originalNum = originalNum;
        this.index = index;
        this.mappedNum = mappedNum;
    }
}

// time O(nlogn)
// space O(n)