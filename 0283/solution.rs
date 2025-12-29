impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        let mut write_to = 0;
        for i in 0..nums.len() {
            if nums[i] != 0 {
                nums.swap(write_to, i);
                write_to += 1;
            }
        }
    }
}
