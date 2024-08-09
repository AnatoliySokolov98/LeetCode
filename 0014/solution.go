package main

func longestCommonPrefix(strs []string) string {
	res := strs[0]
	for i, v := range strs[1:] {
		j := 0
		for i < len(v) && j < len(res) {
			if v[i] == res[j] {
				i++
				j++
			} else {
				break
			}
		}
		res = res[:j]
	}
	return res
}
