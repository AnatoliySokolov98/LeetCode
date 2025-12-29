impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        let mut n1 = num1.chars().rev();
        let mut n2 = num2.chars().rev();
        let mut carry = 0;
        let mut res = String::with_capacity(num1.len().max(num2.len()) + 1);

        loop {
            let d1 = n1.next().and_then(|c| c.to_digit(10));
            let d2 = n2.next().and_then(|c| c.to_digit(10));

            if d1.is_none() && d2.is_none() && carry == 0 {
                break;
            }

            let total = d1.unwrap_or(0) + d2.unwrap_or(0) + carry;
            carry = total / 10;
            res.push(char::from_digit(total % 10, 10).unwrap());
        }

        res.chars().rev().collect()
    }
}
