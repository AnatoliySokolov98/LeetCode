package main

func wordSubsets(words1 []string, words2 []string) []string {
	counts := make([]int, 26)
	for _, word := range words2 {
		currCount := make([]int, 26)
		for i := 0; i < len(word); i++ {
			currCount[word[i]-'a']++
		}
		for i := 0; i < 26; i++ {
			counts[i] = max(counts[i], currCount[i])
		}
	}
	res := make([]string, 0)
	for _, word := range words1 {
		currCount := make([]int, 26)
		for i := 0; i < len(word); i++ {
			currCount[word[i]-'a']++
		}
		res = append(res, word)
		for i := 0; i < 26; i++ {
			if counts[i] > currCount[i] {
				res = res[:len(res)-1]
				break
			}
		}
	}
	return res
}

//time O(m + n)
//space O(1)
