package main

func findComplement(num int) int {
	bits := 0
	res := num
	for num > 0 {
		num >>= 1
		bits <<= 1
		bits += 1
	}
	return bits - res
}