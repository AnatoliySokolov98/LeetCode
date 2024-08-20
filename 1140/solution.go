package main

func stoneGameII(piles []int) int {
	n := len(piles)
	cache := make([][][]int, n)
	for i := range cache {
		cache[i] = make([][]int, n+1)
		for j := range cache[i] {
			cache[i][j] = make([]int, 2)
			for k := range cache[i][j] {
				cache[i][j][k] = -1
			}
		}
	}

	var dp func(index, M, turn int) int
	dp = func(index, M, turn int) int {
		if index >= n {
			return 0
		}
		if cache[index][M][turn] != -1 {
			return cache[index][M][turn]
		}

		var res int
		if turn == 1 { // Alice's turn
			res = 0
		} else { // Bob's turn
			res = int(^uint(0) >> 1) // Set to infinity
		}

		stones := 0
		for X := 0; X < 2*M; X++ {
			if index+X >= n {
				break
			}
			stones += piles[index+X]
			if turn == 1 { // Alice's turn
				res = max(res, stones+dp(index+X+1, maxInt(M, X+1), 0))
			} else { // Bob's turn
				res = min(res, dp(index+X+1, maxInt(M, X+1), 1))
			}
		}

		cache[index][M][turn] = res
		return res
	}

	return dp(0, 1, 1)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
