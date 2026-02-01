impl Solution {
    pub fn longest_alternating(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n == 0 {
            return 0;
        }

        let mut lefts = vec![[1, 1]; n];
        let mut rights = vec![[1, 1]; n];

        for i in 1..n {
            if nums[i] > nums[i - 1] {
                lefts[i][0] = lefts[i - 1][1] + 1;
                lefts[i][1] = 1;
            } else if nums[i] < nums[i - 1] {
                lefts[i][1] = lefts[i - 1][0] + 1;
                lefts[i][0] = 1;
            }
        }

        for i in (0..n - 1).rev() {
            if nums[i] > nums[i + 1] {
                rights[i][0] = rights[i + 1][1] + 1;
                rights[i][1] = 1;
            } else if nums[i] < nums[i + 1] {
                rights[i][1] = rights[i + 1][0] + 1;
                rights[i][0] = 1;
            }
        }

        let mut res = 1;
        for i in 0..n {
            res = res
                .max(lefts[i][0])
                .max(lefts[i][1])
                .max(rights[i][0])
                .max(rights[i][1]);
        }
        for i in 1..n - 1 {
            if nums[i - 1] > nums[i + 1] {
                res = res.max(lefts[i - 1][0] + rights[i + 1][1]);
            } else if nums[i - 1] < nums[i + 1] {
                res = res.max(lefts[i - 1][1] + rights[i + 1][0]);
            }
        }

        res
    }
}
