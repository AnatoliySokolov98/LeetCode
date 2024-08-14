package main

import (
	"sort"
)

func maxProductDifference(nums []int) int {
    var curr []int
    for _, num := range nums {
        curr = append(curr, num)
        sort.Ints(curr)
        if len(curr) > 4 {
            curr = append(curr[:2], curr[3:]...) 
        }
    }

    return curr[3] * curr[2] - curr[1] * curr[0]
}