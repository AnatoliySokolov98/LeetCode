package main

func twoSum(nums []int, target int) []int {
	cache := make(map[int]int)
	for i, v := range nums {
		complement := target - v
		j, ok := cache[complement]
		if ok {
			return []int{i, j}
		}
		cache[v] = i
	}
	return []int{-1, -1}
}