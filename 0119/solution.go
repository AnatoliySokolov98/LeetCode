package main

func getRow(rowIndex int) []int {
	prevRow := []int{1}
	for i := 1; i <= rowIndex; i++ {
		row := make([]int, i+1)
		row[0] = 1
		for j := 1; j < len(row)-1; j++ {
			row[j] = prevRow[j-1] + prevRow[j]
		}
		row[len(row)-1] = 1
		prevRow = row
	}
	return prevRow
}
