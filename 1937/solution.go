package main

func maxPoints(points [][]int) int64 {
	ROWS, COLS := len(points), len(points[0])
	prevRow := make([]int64, COLS)
	for i := range prevRow {
		prevRow[i] = int64(points[0][i])
	}

	for i := 1; i < ROWS; i++ {
		currRow := make([]int64, COLS)
		l := int64(0)
		for j := 0; j < COLS; j++ {
			l = max64(l-1, prevRow[j])
			currRow[j] = int64(points[i][j]) + l
		}
		r := int64(0)
		for j := COLS - 1; j >= 0; j-- {
			r = max64(r-1, prevRow[j])
			currRow[j] = max64(currRow[j], int64(points[i][j])+r)
		}
		prevRow = currRow
	}

	res := int64(0)
	for _, v := range prevRow {
		res = max64(res, v)
	}
	return res
}

func max64(a int64, b int64) int64 {
	if a > b {
		return a
	}
	return b
}
