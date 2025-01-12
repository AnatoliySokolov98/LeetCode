package main

func canBeValid(s string, locked string) bool {
	if len(s)%2 != 0 {
		return false
	}
	openCount, unlockCount := 0, 0
	for i := 0; i < len(s); i++ {
		if locked[i] == '0' {
			unlockCount++
		} else if s[i] == '(' {
			openCount++
		} else {
			if openCount > 0 {
				openCount--
			} else if unlockCount > 0 {
				unlockCount--
			} else {
				return false
			}
		}
	}
	openCount, unlockCount = 0, 0
	for i := len(s) - 1; i >= 0; i-- {
		if locked[i] == '0' {
			unlockCount++
		} else if s[i] == ')' {
			openCount++
		} else {
			if openCount > 0 {
				openCount--
			} else if unlockCount > 0 {
				unlockCount--
			} else {
				return false
			}
		}
	}
	return true
}
