impl Solution {
    pub fn calculate(s: String) -> i32 {
        let mut op = '+';
        let mut total: i32 = 0;
        let mut prev: i32 = 0;
        let mut curr: i32 = 0;
        let apply_op = |op: char, total: &mut i32, prev: &mut i32, curr: &mut i32| {
            match op {
                '+' => {
                    *total += *prev;
                    *prev = *curr;
                }
                '-' => {
                    *total += *prev;
                    *prev = -*curr;
                }
                '*' => *prev *= *curr,
                '/' => *prev /= *curr,
                _ => {}
            }
            *curr = 0;
        };

        for char in s.chars() {
            if char == ' ' {
                continue;
            }
            if let Some(digit) = char.to_digit(10) {
                curr = curr * 10 + (digit as i32);
                continue;
            }
            apply_op(op, &mut total, &mut prev, &mut curr);
            op = char;
        }
        apply_op(op, &mut total, &mut prev, &mut curr);
        total + prev
    }
}
