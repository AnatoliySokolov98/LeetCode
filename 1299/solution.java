class Solution {
    public int[] replaceElements(int[] arr) {
        int right = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int biggest = Math.max(right, arr[i]);
            arr[i] = right;
            right = biggest;
        }
        return arr;
    }
}