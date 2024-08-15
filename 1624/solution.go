package main

func maxLengthBetweenEqualCharacters(s string) int {
	res := -1
	locs := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		char := s[i]
		loc, ok := locs[char]
		if ok {
			res = max(res, i-loc-1)
		} else {
			locs[char] = i
		}
	}
	return res
}

func max(a int, b int) int {
	if a >= b {
		return a
	}
	return b
}