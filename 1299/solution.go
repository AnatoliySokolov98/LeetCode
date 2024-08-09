package main

func replaceElements(arr []int) []int {
	curr := -1
	for i := len(arr) - 1; i >= 0; i-- {
		temp := arr[i]
		arr[i] = curr
		curr = max(curr, temp)
	}
	return arr
}

func max(first int, second int) int {
	if first >= second {
		return first
	}
	return second
}