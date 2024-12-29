package main

type Tuple struct {
	i int
	j int
}

const MOD = 1_000_000_007

func numWays(words []string, target string) int {
	W := len(words[0])
	counts := make([][26]int, W)

	for _, word := range words {
		for i, char := range word {
			counts[i][char-'a']++
		}
	}

	cache := make(map[Tuple]int)
	return dp(0, 0, target, counts, cache)
}

func dp(i int, j int, target string, counts [][26]int, cache map[Tuple]int) int {
	W := len(counts)
	T := len(target)

	// Base cases
	if j == T {
		return 1 // Reached the end of the target string
	}
	if i == W || T-j > W-i {
		return 0 // Out of bounds or not enough positions left to match
	}

	// Check cache
	if val, ok := cache[Tuple{i, j}]; ok {
		return val
	}

	res := 0
	char := target[j] - 'a'
	count := counts[i][char]

	// Include the current character
	if count > 0 {
		res = (res + (count*dp(i+1, j+1, target, counts, cache))%MOD) % MOD
	}

	// Skip the current position
	res = (res + dp(i+1, j, target, counts, cache)) % MOD

	// Store in cache
	cache[Tuple{i, j}] = res
	return res
}

// time O(words * W + W * T)
// space O(W * T)
