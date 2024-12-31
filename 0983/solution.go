package main

func mincostTickets(days []int, costs []int) int {
	cache := make(map[int]int)
	return dp(0, days, costs, cache)
}

func dp(i int, days []int, costs []int, cache map[int]int) int {
	if i == len(days) {
		return 0
	}
	if val, ok := cache[i]; ok {
		return val
	}
	res := costs[0] + dp(i+1, days, costs, cache)
	j := i
	for j < len(days) && days[j]-days[i] < 7 {
		j++
	}
	res = min(res, costs[1]+dp(j, days, costs, cache))
	for j < len(days) && days[j]-days[i] < 30 {
		j++
	}
	res = min(res, costs[2]+dp(j, days, costs, cache))
	cache[i] = res
	return res
}

// time O(n)
// space O(n)
