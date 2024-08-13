package main

func abs(num int) int {
	if num < 0 {
		return -num
	} else {
		return num
	}
}

func findDisappearedNumbers(nums []int) []int {
	for _, num := range nums {
		if nums[abs(num)-1] > 0 {
			nums[abs(num)-1] *= -1
		}
	}
	res := []int{}
	for i, num := range nums {
		if num > 0 {
			res = append(res, i+1)
		}
	}
	return res
}