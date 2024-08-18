package main

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	counts := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		counts[s[i]]++
		counts[t[i]]--
	}
	for _, value := range counts {
		if value != 0 {
			return false
		}
	}
	return true
}