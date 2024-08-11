package main

func canPlaceFlowers(flowerbed []int, n int) bool {
	flowerbed = append([]int{0}, flowerbed...)
	flowerbed = append(flowerbed, 0)
	res := 0
	for i := 1; i < len(flowerbed)-1; {
		if flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 {
			res++
			i += 2
		} else {
			i += 1
		}
	}
	return res >= n
}