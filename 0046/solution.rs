impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut nums = nums.clone();
        let mut res: Vec<Vec<i32>> = Vec::new();
        Self::backtrack(&mut nums, &mut res, 0);
        return res;
    }

    fn backtrack(nums: &mut Vec<i32>, mut res: &mut Vec<Vec<i32>>, i: usize) {
        if (i == nums.len()) {
            res.push(nums.clone());
            return;
        }
        for j in i..nums.len() {
            nums.swap(i, j);
            Self::backtrack(nums, res, i + 1);
            nums.swap(i, j);
        }
    }
}
