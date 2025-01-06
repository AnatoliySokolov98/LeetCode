package main

func minOperations(boxes string) []int {
	B := len(boxes)
	res := make([]int, B)
	balls, total := 0, 0

	for i := B - 1; i >= 0; i-- {
		total += balls
		res[i] = total
		balls += int(boxes[i] - '0')
	}
	balls, total = 0, 0
	for i := 0; i < B; i++ {
		total += balls
		res[i] += total
		balls += int(boxes[i] - '0')
	}
	return res
}

// time O(n)
// space O(1)
