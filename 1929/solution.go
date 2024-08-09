package main

func getConcatenation(nums []int) []int {
	return append(nums, nums...)
}