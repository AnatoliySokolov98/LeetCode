package main

func waysToSplitArray(nums []int) int {
	r, l := 0, 0
	for _, num := range nums {
		r += num
	}
	res := 0
	for i := 0; i < len(nums)-1; i++ {
		l += nums[i]
		r -= nums[i]
		if l >= r {
			res++
		}
	}
	return res
}

// time O(n)
// space O(1)
