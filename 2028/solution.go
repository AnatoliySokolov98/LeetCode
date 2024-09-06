package main

func missingRolls(m []int, mean int, n int) []int {
	mTotal := 0
	for _, v := range m {
		mTotal += v
	}
	nTotal := mean*(n+len(m)) - mTotal
	if nTotal < n || nTotal > n*6 {
		return []int{}
	}

	val := nTotal / n
	mod := nTotal % n
	res := make([]int, n)
	for i := range n {
		res[i] = val
		if i < mod {
			res[i]++
		}
	}
	return res
}