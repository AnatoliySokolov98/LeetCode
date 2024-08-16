package main

func countStudents(students []int, sandwiches []int) int {
	counts := [2]int{0, 0}
	for _, num := range students {
		counts[num]++
	}

	for i, num := range sandwiches {
		if counts[num] == 0 {
			return len(sandwiches) - i
		}
		counts[num]--
	}
	return 0
}