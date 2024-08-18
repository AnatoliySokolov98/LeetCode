package main

func nthUglyNumber(n int) int {
	uglyNums := make([]int, n)
	uglyNums[0] = 1
	twos := 0
	threes := 0
	fives := 0

	for i := 1; i < n; i++ {
		uglyNums[i] = min(uglyNums[twos]*2, min(uglyNums[threes]*3, uglyNums[fives]*5))
		if uglyNums[i] == uglyNums[twos]*2 {
			twos++
		}
		if uglyNums[i] == uglyNums[threes]*3 {
			threes++
		}
		if uglyNums[i] == uglyNums[fives]*5 {
			fives++
		}
	}
	return uglyNums[n-1]
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}