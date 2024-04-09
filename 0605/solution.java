class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed[0] == 0 && ((flowerbed.length > 1 && flowerbed[1] == 0) || flowerbed.length == 1)) {
            flowerbed[0] = 1;
            n--;
        }
         if (flowerbed[flowerbed.length -1] == 0 && ((flowerbed.length > 1 && flowerbed[flowerbed.length - 2] == 0) || flowerbed.length == 1)) {
            flowerbed[flowerbed.length-1] = 1;
            n--;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i]++;
            }
        }
        return n <=0;
    }
}