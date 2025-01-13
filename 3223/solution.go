package main

func minimumLength(s string) int {
	counts := make([]int, 26)
	for i := 0; i < len(s); i++ {
		counts[s[i]-'a']++
	}
	res := 0
	for _, val := range counts {
		if val <= 2 {
			res += val
		} else {
			if val%2 == 0 {
				res += 2
			} else {
				res++
			}
		}
	}
	return res
}

// time O(n)
// space O(1)
