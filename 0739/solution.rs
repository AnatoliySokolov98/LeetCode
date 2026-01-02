use std::collections::VecDeque;

impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let mut res: Vec<i32> = vec![0; temperatures.len()];
        let mut stack: VecDeque<usize> = VecDeque::new();
        for (i, &v) in temperatures.iter().enumerate() {
            while !stack.is_empty() && v > temperatures[*stack.back().unwrap()] {
                let loc = stack.pop_back().unwrap();
                res[loc] = (i - loc) as i32;
            }
            stack.push_back(i);
        }
        return res;
    }
}
