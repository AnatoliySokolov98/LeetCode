package main

import (
	"sort"
	"strings"
)

func groupAnagrams(strs []string) [][]string {
    anagrams := make(map[string][]string)
    for _, word := range strs {
        arr := strings.Split(word, "")
        sort.Strings(arr)
        sortedWord := strings.Join(arr, "")
        anagrams[sortedWord] = append(anagrams[sortedWord], word)
    }
    
    res := make([][]string, 0, len(anagrams))
    for _, val := range anagrams {
        res = append(res, val)
    }
    return res   
}