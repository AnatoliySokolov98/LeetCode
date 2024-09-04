package main

func getLucky(s string, k int) int {
	total := 0
	for _, v := range s {
		num := int(v - 'a' + 1)
		for num > 0 {
			total += num % 10
			num /= 10
		}
	}
	k--
	for k > 0 {
		newTotal := 0
		for total > 0 {
			newTotal += total % 10
			total /= 10
		}
		total = newTotal
		k--
	}
	return total
}