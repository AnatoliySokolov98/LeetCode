package main

import "strings"

func shiftingLetters(s string, shifts [][]int) string {
	S := len(s)
	line := make([]int, S+1)
	for _, v := range shifts {
		x, y, dir := v[0], v[1], v[2]
		if dir == 0 {
			line[x]--
			line[y+1]++
		} else {
			line[x]++
			line[y+1]--
		}
	}
	var sb strings.Builder
	total := 0
	for i := 0; i < S; i++ {
		total += line[i]
		shift := (int(s[i]-'a') + total) % 26
		if shift < 0 {
			shift += 26
		}
		sb.WriteByte(byte(shift) + 'a')
	}
	return sb.String()
}

//time O(m + n)
//space O(n)
