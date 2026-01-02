impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        let mut pivot = None;
        for i in (0..nums.len() - 1).rev() {
            if nums[i] < nums[i + 1] {
                pivot = Some(i);
                break;
            }
        }

        let start = match pivot {
            Some(i) => {
                for j in (i + 1..nums.len()).rev() {
                    if nums[j] > nums[i] {
                        nums.swap(i, j);
                        break;
                    }
                }
                i + 1
            }
            None => 0,
        };
        nums[start..].reverse()
    }
}
