package main

func doesValidArrayExist(derived []int) bool {
	res := 0
	for _, num := range derived {
		res ^= num
	}
	return res == 0
}

// time O(n)
// space O(1)
