package main

func numIdenticalPairs(nums []int) int {
    counts := make(map[int] int)
    res := 0
    for _, num := range nums {
        val, ok := counts[num]
        if ok {
            res += val
        }
        counts[num]++
    }
    return res
}