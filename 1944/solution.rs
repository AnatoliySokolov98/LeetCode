use std::collections::VecDeque;


impl Solution {
    fn can_see_persons_count(heights: Vec<i32>) -> Vec<i32> {
        let mut res = vec![0; heights.len()];
        let mut queue: VecDeque<usize> = VecDeque::new();
        for (i, &v) in heights.iter().enumerate().rev() {
            let mut count = 0;
            while let Some(&val) = queue.front() && v >= heights[val] {
              queue.pop_front();
              count += 1
            }
            if !queue.is_empty() {
                count += 1;
            }
            res[i] = count;
            queue.push_front(i);
        }
        return res;
    }
}