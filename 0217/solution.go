package main

func containsDuplicate(nums []int) bool {
	uniques := make(map[int]bool)
	for _, num := range nums {
		_, ok := uniques[num]
		if ok {
			return true
		}
		uniques[num] = true
	}
	return false
}