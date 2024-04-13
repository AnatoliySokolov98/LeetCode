import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort the array to use the two-pointer approach
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;

        // Use two pointers to find the number of boats needed
        while (left <= right) {
            // If the lightest and heaviest person can share a boat, increment left
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // Always move the right pointer to include the heaviest person
            right--;
            // A boat is used in each iteration
            res++;
        }
        return res;
    }
}
