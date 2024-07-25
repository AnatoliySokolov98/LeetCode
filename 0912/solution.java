import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int pivot = nums[p];
        nums[p] = nums[r];
        nums[r] = pivot;
        int i = l;
        int j = l;
        int k = r;

        while (j <= k) {
            if (nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else if (nums[j] > pivot) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else {
                j++;
            }
        }
        quickSort(nums, l, i - 1);
        quickSort(nums, k + 1, r);
    }
}

// time O(nlogn)
// space O(logn)