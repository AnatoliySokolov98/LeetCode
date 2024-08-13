package main

func isIsomorphic(s string, t string) bool {
	sMap := make(map[byte]byte)
	tMap := make(map[byte]byte)
	if len(s) != len(t) {
		return false
	}

	for i := 0; i < len(s); i++ {
		val, ok := sMap[s[i]]
		if ok && val != t[i] {
			return false
		} else {
			sMap[s[i]] = t[i]
		}
		val, ok = tMap[t[i]]
		if ok && val != s[i] {
			return false
		} else {
			tMap[t[i]] = s[i]
		}
	}
	return true
}