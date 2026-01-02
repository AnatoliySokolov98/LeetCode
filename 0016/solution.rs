impl Solution {
    pub fn three_sum_closest(mut nums: Vec<i32>, target: i32) -> i32 {
        nums.sort();
        let mut res = nums[0] + nums[1] + nums[2];
        for (i, v) in nums.iter().enumerate() {
            let mut left = i + 1;
            let mut right = nums.len() - 1;
            while left < right {
                let total = nums[left] + nums[right] + nums[i];

                if (target - total).abs() < (target - res).abs() {
                    res = total;
                }
                if total == target {
                    return target;
                }
                if total < target {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return res;
    }
}
