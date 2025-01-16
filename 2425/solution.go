package main

func xorAllNums(nums1 []int, nums2 []int) int {
	N1, N2 := len(nums1), len(nums2)
	res := 0
	if N1%2 == 1 {
		for _, v := range nums2 {
			res ^= v
		}
	}
	if N2%2 == 1 {
		for _, v := range nums1 {
			res ^= v
		}
	}
	return res
}

// time O(n + m)
// space O(1)
