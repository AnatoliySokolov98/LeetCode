package main

func intersection(nums1 []int, nums2 []int) []int {
	set1 := make(map[int]bool)
	set2 := make(map[int]bool)
	for _, num := range nums1 {
		set1[num] = true
	}
	for _, num := range nums2 {
		set2[num] = true
	}
	res := make([]int, 0)
	for key := range set1 {
		if set2[key] {
			res = append(res, key)
		}
	}
	return res
}