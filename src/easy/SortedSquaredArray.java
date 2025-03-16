package easy;

import java.util.Arrays;

/**
 * Solution for the Sorted Squared Array problem.
 */
public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] array = { -7, -5, -3, -1, 2, 4, 6 };
        System.out.println(Arrays.toString(getSquaredSortedArray(array)));
    }

    /**
     * Returns a new array with the squares of each number sorted in ascending order.
     * Uses a two-pointer approach to optimize for time complexity.
     *
     * @param array A sorted integer array
     * @return A sorted array of squares of the input array elements
     * 
     * Time Complexity: O(n) - where n is the length of the input array
     * Space Complexity: O(n) - for storing the result array
     */
    private static int[] getSquaredSortedArray(int[] array) {
        int[] squaredArray = new int[array.length];
        int leftIdx = 0, rightIdx = array.length - 1, squaredArrayIdx = squaredArray.length - 1;
        
        // Compare absolute values from both ends and place squares in descending order
        while (leftIdx <= rightIdx) {
            if (Math.abs(array[rightIdx]) > Math.abs(array[leftIdx])) {
                squaredArray[squaredArrayIdx] = array[rightIdx] * array[rightIdx];  // More efficient than Math.pow
                rightIdx--;
            } else {
                squaredArray[squaredArrayIdx] = array[leftIdx] * array[leftIdx];
                leftIdx++;
            }
            squaredArrayIdx--;
        }
        return squaredArray;
    }
}
