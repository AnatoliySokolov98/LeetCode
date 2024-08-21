package main

func strangePrinter(s string) int {
	// Remove consecutive duplicates
	s = removeDuplicates(s)

	n := len(s)
	memo := make([][]int, n)
	for i := range memo {
		memo[i] = make([]int, n)
	}

	return dp(s, 0, n-1, memo)
}

func removeDuplicates(s string) string {
	result := []byte{s[0]}
	for i := 1; i < len(s); i++ {
		if s[i] != s[i-1] {
			result = append(result, s[i])
		}
	}
	return string(result)
}

func dp(s string, i, j int, memo [][]int) int {
	if i > j {
		return 0
	}
	if memo[i][j] != 0 {
		return memo[i][j]
	}

	res := 1 + dp(s, i+1, j, memo)

	for k := i + 1; k <= j; k++ {
		if s[i] == s[k] {
			res = min(res, dp(s, i+1, k, memo)+dp(s, k+1, j, memo))
		}
	}

	memo[i][j] = res
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
