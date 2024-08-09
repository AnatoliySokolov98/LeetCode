package main

func countCharacters(words []string, chars string) int {
	totalCounts := [26]int{}
    for _, c := range chars {
        totalCounts[c - 'a']++
    }

    res := 0
    for _, word := range words {
        letterCounts := [26]int{}
        for _, c := range word {
            letterCounts[c - 'a']++
        }
        valid := true
        for i := 0; i < 26; i++ {
            if letterCounts[i] > totalCounts[i] {
                valid = false
                break
            }
        }
        if valid {
            res += len(word)
        }
    }
    return res
}