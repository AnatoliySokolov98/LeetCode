package main

import (
	"math"
)

func minSteps(n int) int {
    res := 0
	root := int(math.Ceil(math.Sqrt(float64(n))))
	factor := 2
	
	for factor <= root {
		for n%factor == 0 {
			res += factor
			n /= factor
		}
		factor++
	}
	
	if n > 1 {
		res += n
	}
	
	return res
}