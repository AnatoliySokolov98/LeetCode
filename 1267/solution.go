package main

func countServers(grid [][]int) int {
	ROWS, COLS := len(grid), len(grid[0])
	rowCounts := make([]int, ROWS)
	colCounts := make([]int, COLS)
	for r := 0; r < ROWS; r++ {
		for c := 0; c < COLS; c++ {
			if grid[r][c] == 1 {
				rowCounts[r]++
				colCounts[c]++
			}
		}
	}
	var res int = 0
	for r := 0; r < ROWS; r++ {
		for c := 0; c < COLS; c++ {
			if grid[r][c] == 1 && (rowCounts[r]+colCounts[c] > 2) {
				res++
			}
		}
	}
	return res
}

// time O(mn)
// space O(m + n)
