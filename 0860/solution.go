package main

func lemonadeChange(bills []int) bool {
	cashier := [2]int{0, 0}
	for _, bill := range bills {
		if bill == 5 {
			cashier[0] += 1
		} else if bill == 10 {
			cashier[1] += 1
			if cashier[0] == 0 {
				return false
			}
			cashier[0] -= 1
		} else {
			if cashier[1] > 0 && cashier[0] > 0 {
				cashier[1] -= 1
				cashier[0] -= 1
			} else if cashier[0] >= 3 {
				cashier[0] -= 3
			} else {
				return false
			}
		}
	}
	return true
}
