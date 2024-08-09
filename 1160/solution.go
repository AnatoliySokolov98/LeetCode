package main

func largestGoodInteger(num string) string {
    res := ""
    for i := 0; i < len(num) - 2; i++ {
        if num[i] == num[i + 1] && num[i + 1] == num[i + 2] {
            if (len(res) == 0 || res[0] < num[i]) {
                res = num[i:i + 3]
            }
        }
    }
    return res
}