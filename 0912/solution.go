package main
func sortArray(nums []int) []int {
    if len(nums) <= 1 {
        return nums
    }
    p := len(nums) / 2
    return merge(sortArray(nums[:p]), sortArray(nums[p:]))
}

func merge(a []int, b []int) []int {
    res := make([]int, 0)
    i := 0
    j := 0
    for i < len(a) || j < len(b) {
        if i < len(a) && (j >= len(b) || a[i] <= b[j]) {
            res = append(res, a[i])
            i++
        } else {
            res = append(res, b[j])
            j++
        }
    }
    return res
}

