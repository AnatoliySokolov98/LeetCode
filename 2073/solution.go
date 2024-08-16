package main

func timeRequiredToBuy(tickets []int, k int) int {
	res := 0
	for i, v := range tickets {
		if i < k {
			res += min(v, tickets[k])
		} else if i == k {
			res += v
		} else {
			res += min(v, tickets[k]-1)
		}
	}
	return res
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}