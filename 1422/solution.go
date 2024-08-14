package main

func maxScore(s string) int {
	ones := 0
	for _, char := range s {
		if char == '1' {
			ones++
		}
	}
	zeroes := 0
	res := 0
	for i, char := range s {
		if i == len(s)-1 {
			break
		}
		if char == '1' {
			ones--
		} else {
			zeroes++
		}
		res = max(res, zeroes+ones)
	}
	return res
}

func max(first int, second int) int {
	if first > second {
		return first
	} else {
		return second
	}
}