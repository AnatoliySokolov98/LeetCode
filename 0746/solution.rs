impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        let  (mut first, mut second) = (0,0);
        for num in cost.into_iter().rev() {
            let temp = num + first.min(second);
            (first, second) = (temp,first);
        }
        return first.min(second);
    }
}