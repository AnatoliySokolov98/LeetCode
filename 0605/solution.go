package main

func findErrorNums(nums []int) []int {
	for _, v := range nums {
		nums[(v-1)%10_000] += 10_000
	}

	res := []int{0, 0}

	for i, v := range nums {
		if v < 10_000 {
			res[1] = i + 1
		} else if v > 20_000 {
			res[0] = i + 1
		}
	}
	return res
}