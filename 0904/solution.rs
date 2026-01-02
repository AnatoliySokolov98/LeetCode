use std::collections::HashMap;

impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        let mut res = 0;
        let mut left = 0;
        let mut counts: HashMap<i32, i32> = HashMap::new();
        for (right, &value) in fruits.iter().enumerate() {
            *counts.entry(value).or_default() += 1;
            while counts.len() > 2 {
                if let Some(left_count) = counts.get_mut(&fruits[left]) {
                    *left_count -= 1;
                    if *left_count == 0 {
                        counts.remove(&fruits[left]);
                    }
                    left += 1;
                } else {
                    return 0;
                }
            }
            res = res.max(right - left + 1);
        }
        return res as i32;
    }
}
