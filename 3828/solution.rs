impl Solution {
    pub fn final_element(nums: Vec<i32>) -> i32 {
        return nums[0].max(nums[nums.len() - 1]);
    }
}
