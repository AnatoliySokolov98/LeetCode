package main

import "sort"
func specialArray(nums []int) int {
    sort.Ints(nums)
    for i, v := range nums {
        bigger := len(nums) - i
        if v >= bigger && (i == 0 || nums[i - 1] < bigger) {
            return bigger
        }
    }
    return -1
}