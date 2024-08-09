package main

func lengthOfLastWord(s string) int {
	loc := len(s) - 1
	for s[loc] == ' ' {
		loc--
	}
	left := loc
	for left > 0 && s[left-1] != ' ' {
		left--
	}
	return loc - left + 1
}