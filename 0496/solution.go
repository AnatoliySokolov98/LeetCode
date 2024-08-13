package main

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	locations := make(map[int]int)
	next_greater := make([]int, len(nums2))
	for i := range next_greater {
		next_greater[i] = -1
	}

	stack := [][]int{}
	for i := 0; i < len(nums2); i++ {
		locations[nums2[i]] = i
		for len(stack) > 0 && nums2[i] > stack[len(stack)-1][1] {
			index := stack[len(stack)-1][0]
			stack = stack[:len(stack)-1]
			next_greater[index] = nums2[i]
		}
		stack = append(stack, []int{i, nums2[i]})
	}

	res := []int{}
	for _, num := range nums1 {
		res = append(res, next_greater[locations[num]])
	}

	return res
}