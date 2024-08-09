package main

func isMonotonic(nums []int) bool {
	inc := true
	dec := true

	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			inc = inc && true
			dec = false
		} else if nums[i] < nums[i-1] {
			dec = dec && true
			inc = false
		}
	}
	return inc || dec
}