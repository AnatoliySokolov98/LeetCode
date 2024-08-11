package main

type Tuple struct {
	x int
	y int
}

func isPathCrossing(path string) bool {
	x, y := 0, 0
	visited := make(map[Tuple]bool)
	visited[Tuple{x, y}] = true
	for _, c := range path {
		if c == 'N' {
			x -= 1
		} else if c == 'S' {
			x += 1
		} else if c == 'E' {
			y += 1
		} else {
			y -= 1
		}
		curr := Tuple{x, y}
		_, ok := visited[curr]
		if ok {
			return true
		}
		visited[curr] = true
	}
	return false
}