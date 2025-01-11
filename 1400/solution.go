package main

func canConstruct(s string, k int) bool {
	counts := [26]int{}
	for i := 0; i < len(s); i++ {
		counts[s[i]-'a']++
	}
	singles := 0
	for _, v := range counts {
		singles += v % 2
	}
	return singles <= k && k <= len(s)
}

// time O(n)
// space O(1)
