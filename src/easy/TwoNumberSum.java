package easy;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * This class contains solutions for the Two Number Sum problem.
 * The problem: Given an array of integers and a target sum, find two numbers
 * in the array that add up to the target sum.
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;
        int[] result = twoNumberSum3(array, targetSum);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("No result found");
        }
    }

    /**
     * Finds two numbers in the array that add up to the target sum using
     * the sorted array with two pointers approach.
     * <p>
     * Time Complexity: O(n log n) due to the sorting operation
     * Space Complexity: O(1) - constant extra space used
     *
     * @param array     The input array of integers
     * @param targetSum The target sum to find
     * @return An array containing the two numbers that add up to the target sum,
     *         or null if no such pair exists
     */
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        // Sort the array first to use two-pointer technique
        Arrays.sort(array);

        // Use two pointers: one starting from left, one from right
        int left = 0;
        int right = array.length - 1;

        // Move pointers toward each other until they meet
        while (left < right) {
            // Calculate current sum
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                // Found a match, return the pair
                return new int[] { array[left], array[right] };
            } else if (currentSum < targetSum) {
                // Sum is too small, increase left pointer to get a larger value
                left++;
            } else {
                // Sum is too large, decrease right pointer to get a smaller value
                right--;
            }
        }

        // No solution found
        return null;
    }

    /**
     * Finds two numbers in the array that add up to the target sum using
     * a hash table to track values.
     * <p>
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(n) - potentially storing all values in the hash table
     *
     * @param array     The input array of integers
     * @param targetSum The target sum to find
     * @return An array containing the two numbers that add up to the target sum,
     *         or null if no such pair exists
     */
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Hashtable<Integer, Boolean> numbers = new Hashtable<>();
        for (int number : array) {
            int potentialMatch = targetSum - number;
            if (numbers.containsKey(potentialMatch)) {
                return new int[] { number, potentialMatch };
            }
            numbers.put(number, true);
        }
        return null;
    }

    /**
     * Finds two numbers in the array that add up to the target sum using
     * a brute force approach with nested loops.
     * <p>
     * Time Complexity: O(n²) - nested loops through the array
     * Space Complexity: O(1) - constant extra space used
     *
     * @param array     The input array of integers
     * @param targetSum The target sum to find
     * @return An array containing the two numbers that add up to the target sum,
     *         or null if no such pair exists
     */
    public static int[] twoNumberSum1(int[] array, int targetSum) {
        // Check each pair of elements in the array
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // If a pair sums to the target, return the pair
                if (array[i] + array[j] == targetSum) {
                    return new int[] { array[i], array[j] };
                }
            }
        }
        // No pair found
        return null;
    }
}
