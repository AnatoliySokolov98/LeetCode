/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  while (n) {
    if (!m || nums2[n - 1] >= nums1[m - 1]) {
      nums1[n - 1 + m] = nums2[n - 1];
      n--;
    } else {
      nums1[m - 1 + n] = nums1[m - 1];
      m--;
    }
  }
}
