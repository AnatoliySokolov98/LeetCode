package main

func lengthOfLongestSubstring(s string) int {
	chars := make(map[byte]int)
	l := 0
	res := 0
	for r := 0; r < len(s); r++ {
		char := s[r]
		chars[char]++
		for chars[char] > 1 {
			chars[s[l]]--
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func max(a int, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}