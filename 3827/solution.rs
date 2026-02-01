impl Solution {
    pub fn count_monobit(mut n: i32) -> i32 {
        let mut res = 0;
        let mut all_ones = true;
        while n > 0 {
            res += 1;
            if (n & 1) == 0 {
                all_ones = false;
            }
            n >>= 1;
        }
        if all_ones {
            res += 1;
        }
        res
    }
}

