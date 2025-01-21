package main

import "math"

func gridGame(grid [][]int) int64 {
	totals := [2]int64{0, 0}
	COLS := len(grid[0])
	for _, v := range grid[0] {
		totals[0] += int64(v)
	}
	var res int64 = math.MaxInt64
	for i := 0; i < COLS; i++ {
		totals[0] -= int64(grid[0][i])
		res = min(res, max(totals[0], totals[1]))
		totals[1] += int64(grid[1][i])
	}
	return res
}
