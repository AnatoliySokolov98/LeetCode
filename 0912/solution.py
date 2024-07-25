import random


class Solution:
    def sortArray(self, nums: list[int]) -> list[int]:
        def quicksort(l, r):
            if l >= r:
                return

            p = random.randint(l, r)
            nums[r], nums[p] = nums[p], nums[r]
            pivot = nums[r]

            i, j, k = l, l, r
            while j <= k:
                if nums[j] < pivot:
                    nums[i], nums[j] = nums[j], nums[i]
                    i += 1
                    j += 1
                elif nums[j] > pivot:
                    nums[j], nums[k] = nums[k], nums[j]
                    k -= 1
                else:
                    j += 1

            quicksort(l, i - 1)
            quicksort(k + 1, r)

        quicksort(0, len(nums) - 1)
        return nums
