package main

func isSubsequence(s string, t string) bool {
	i := 0
	for j := 0; j < len(t); j++ {
		if i == len(s) {
			return true
		}
		if s[i] == t[j] {
			i++
		}
	}
	return i == len(s)
}