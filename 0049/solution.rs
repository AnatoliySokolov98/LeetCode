impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut anagrams: HashMap<String, Vec<String>> = HashMap::new();
        for s in strs {
            let mut chars: Vec<char> = s.chars().collect();
            chars.sort();
            let sorted: String = chars.into_iter().collect();
            anagrams.entry(sorted).or_default().push(s);
        }
        return anagrams.into_values().collect()
    }
}
