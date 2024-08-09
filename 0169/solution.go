package main

func majorityElement(nums []int) int {
	total := -1
	res := -1
	for _, num := range nums {
		if num != res {
			total--
			if total <= 0 {
				total = 1
				res = num
			}
		} else {
			total++
		}
	}
	return res
}