impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let len = heights.len();
        let mut lefts: Vec<i32> = vec![-1; len];
        let mut rights: Vec<usize> = vec![len; len];
        let mut stack: Vec<usize> = Vec::new();
        let mut res = 0;
        for (i, &v) in heights.iter().enumerate() {
            while let Some(&j) = stack.last()
                && heights[j] > v
            {
                rights[j] = i;
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for (i, &v) in heights.iter().enumerate().rev() {
            while let Some(&j) = stack.last()
                && heights[j] > v
            {
                lefts[j] = i as i32;
                stack.pop();
            }
            stack.push(i);
        }
        for i in 0..len {
            let height = heights[i];
            let width: i32 = (rights[i] as i32) - lefts[i] - 1;
            res = res.max(height * width);
        }
        return res;
    }
}
