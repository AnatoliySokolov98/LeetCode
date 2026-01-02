impl Solution {
    pub fn reverse_words(s: String) -> String {
        let mut words: Vec<&str> = s.split_whitespace().collect();
        words.reverse();
        return words.join(" ");
    }
}
