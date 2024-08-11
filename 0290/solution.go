package main

import (
	"strings"
)

func wordPattern(p string, str string) bool {
    s := strings.Split(str, " ")
    pMap := make(map[byte]string)
    sMap := make(map[string]byte)
    if len(p) != len(s) {
        return false
    }

    for i := 0; i < len(p); i++ {
        val, ok := pMap[p[i]]
        if ok {
            if val != s[i] {
                return false
            }
        } else {
            pMap[p[i]] = s[i]
        }
        val2, ok := sMap[s[i]]
        if ok {
            if val2 != p[i] {
                return false
            }
        } else {
            sMap[s[i]] = p[i]
        }
    }
    return true
}