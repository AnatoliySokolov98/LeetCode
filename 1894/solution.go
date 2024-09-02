package main

func chalkReplacer(chalk []int, k int) int {
	total := 0
	for _, v := range chalk {
		total += v
	}
	k %= total
	for i, v := range chalk {
		if v > k {
			return i
		}
		k -= v
	}
	return -1
}