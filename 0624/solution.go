package main

func maxDistance(arrays [][]int) int {
	res := 0
	prevBig := arrays[0][len(arrays[0])-1]
	prevSmall := arrays[0][0]

	for i := 1; i < len(arrays); i++ {
		currBig := arrays[i][len(arrays[i])-1]
		currSmall := arrays[i][0]
		res = max(res, currBig-prevSmall)
		res = max(res, prevBig-currSmall)
		prevBig = max(prevBig, currBig)
		prevSmall = min(prevSmall, currSmall)
	}
	return res
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}