package main

func minOperations(s string) int {
	res1 := 0
	res2 := 0
	for i, char := range s {
		if int(char)-'0' == i%2 {
			res2++
		} else {
			res1++
		}
	}
	if res2 > res1 {
		return res1
	} else {
		return res2
	}
}