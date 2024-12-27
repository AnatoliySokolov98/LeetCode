package main

import "math"

func maxScoreSightseeingPair(values []int) int {
	res := 1
	x := math.MinInt + 1
	for _, v := range values {
		x--
		res = max(res, v+x)
		x = max(x, v)
	}
	return res
}

// time O(n)
// space O(1)
