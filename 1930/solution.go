package main

func countPalindromicSubsequence(s string) int {
	res := make(map[string]struct{})
	left := make(map[byte]struct{})
	right := make(map[byte]int)

	for i := 0; i < len(s); i++ {
		right[s[i]]++
	}

	for i := 0; i < len(s); i++ {
		char := s[i]
		right[char]--
		if right[char] == 0 {
			delete(right, char)
		}

		for leftChar := range left {
			if _, ok := right[leftChar]; ok {
				palindrome := string(leftChar) + string(char) + string(leftChar)
				res[palindrome] = struct{}{}
			}
		}
		left[char] = struct{}{}
	}
	return len(res)
}

// time O(n)
// space O(1)
