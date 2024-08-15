package main

func makeEqual(words []string) bool {
	counts := [26]int{}
	for _, word := range words {
		for _, char := range word {
			counts[int(char)-'a']++
		}
	}

	for _, num := range counts {
		if num%len(words) != 0 {
			return false
		}
	}
	return true
}