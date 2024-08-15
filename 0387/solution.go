package main

func firstUniqChar(s string) int {
	counts := [26]int{}
	for _, val := range s {
		counts[int(val)-'a']++
	}
	for i, val := range s {
		if counts[int(val)-'a'] == 1 {
			return i
		}
	}
	return -1
}