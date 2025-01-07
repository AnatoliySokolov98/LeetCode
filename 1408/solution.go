package main

func stringMatching(words []string) []string {
	res := make([]string, 0)
	for i, word1 := range words {
		added := false
		for j, word2 := range words {
			if added {
				break
			}
			if i == j || len(word1) > len(word2) {
				continue
			}
			for k := 0; k <= len(word2)-len(word1); k++ {
				if word1 == word2[k:k+len(word1)] {
					res = append(res, word1)
					added = true
					break
				}
			}
		}
	}
	return res
}
