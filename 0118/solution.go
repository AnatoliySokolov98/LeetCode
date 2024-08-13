package main

func generate(numRows int) [][]int {
	res := [][]int{{1}}
	for i := 1; i < numRows; i++ {
		row := make([]int, i+1)
		row[0] = 1
		for j := 1; j < len(row)-1; j++ {
			row[j] = res[len(res)-1][j-1] + res[len(res)-1][j]
		}
		row[len(row)-1] = 1
		res = append(res, row)
	}
	return res
}