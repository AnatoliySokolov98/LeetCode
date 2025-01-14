package main

func findThePrefixCommonArray(A []int, B []int) []int {
	res := make([]int, 0)
	a, b := 0, 0
	for i := 0; i < len(A); i++ {
		a |= 1 << A[i]
		b |= 1 << B[i]
		c := a & b
		res = append(res, bitCount(c))
	}
	return res
}

func bitCount(a int) int {
	res := 0
	for a != 0 {
		res += a & 1
		a >>= 1
	}
	return res
}

// time O(n)
// space O(1)
