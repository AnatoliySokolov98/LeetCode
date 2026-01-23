impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        let mut stack = Vec::<i32>::new();
        'outer: for asteroid in asteroids {
            while let Some(&curr) = stack.last()
                && curr > 0
                && asteroid < 0
            {
                if curr == asteroid.abs() {
                    stack.pop();
                    continue 'outer;
                }
                if curr < asteroid.abs() {
                    stack.pop();
                } else {
                    continue 'outer;
                }
            }
            stack.push(asteroid);
        }
        return stack;
    }
}
