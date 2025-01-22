package main

import "container/list"

func highestPeak(isWater [][]int) [][]int {
	ROWS, COLS := len(isWater), len(isWater[0])
	directions := [][]int{
		{1, 0}, {0, 1}, {-1, 0}, {0, -1},
	}
	res := make([][]int, ROWS)
	for i := 0; i < ROWS; i++ {
		res[i] = make([]int, COLS)
	}
	visited := make(map[[2]int]bool)
	bfs := list.New()
	for r := 0; r < ROWS; r++ {
		for c := 0; c < COLS; c++ {
			if isWater[r][c] == 1 {
				bfs.PushBack([3]int{0, r, c})
				visited[[2]int{r, c}] = true
			}
		}
	}

	for bfs.Len() > 0 {
		elem := bfs.Front()
		bfs.Remove(elem)
		current := elem.Value.([3]int)
		num, x, y := current[0], current[1], current[2]

		res[x][y] = num

		for _, dir := range directions {
			nr, nc := x+dir[0], y+dir[1]
			if nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visited[[2]int{nr, nc}] {
				continue
			}
			visited[[2]int{nr, nc}] = true
			bfs.PushBack([3]int{num + 1, nr, nc})
		}
	}

	return res
}
