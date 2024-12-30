package main

func countGoodStrings(low int, high int, zero int, one int) int {
	const MOD int = 1_000_000_007
	dp := make([]int, high+1)
	dp[0] = 1
	res := 0
	for i := 0; i <= high; i++ {
		if i+zero <= high {
			dp[i+zero] = (dp[i+zero] + dp[i]) % MOD
		}
		if i+one <= high {
			dp[i+one] = (dp[i+one] + dp[i]) % MOD
		}
		if i >= low && i <= high {
			res = (res + dp[i]) % MOD
		}
	}
	return res
}

// time O(n)
// space O(n)
