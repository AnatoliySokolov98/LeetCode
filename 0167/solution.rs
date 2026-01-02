impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        let mut left = 0;
        let mut right = numbers.len() - 1;
        while left < right {
            let total = numbers[left] + numbers[right];
            if total == target {
                return vec![(left + 1) as i32, (right + 1) as i32];
            }
            if total < target {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return vec![];
    }
}
