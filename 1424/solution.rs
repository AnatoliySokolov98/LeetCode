use std::collections::HashMap;

impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        let mut diags: HashMap<usize, Vec<i32>> = HashMap::new();
        let mut biggest_key = 0;

        for row in (0..nums.len()).rev() {
            for (col, &v) in nums[row].iter().enumerate() {
                let key = row + col;
                diags.entry(key).or_default().push(v);
                biggest_key = biggest_key.max(key);
            }
        }

        let mut res = Vec::new();
        for key in 0..=biggest_key {
            if let Some(val) = diags.get(&key) {
                res.extend(val);
            }
        }
        return res;
    }
}
