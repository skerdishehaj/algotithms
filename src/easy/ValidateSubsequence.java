package easy;

public class ValidateSubsequence {

    public static void main(String[] args) {
        int[] array = { 5, 1, 22, 25, 6, -1, 8, 10 };
        int[] sequence = { 1, 6, -1, 10 };
        System.out.println(isValidSubsequence(array, sequence));
    }

    /**
     * Determines whether the second array is a subsequence of the first array.
     * A subsequence is defined as a set of numbers that aren't necessarily adjacent
     * in the original array but that are in the same order as they appear in the
     * original array.
     * 
     * @param array    the main array to check against
     * @param sequence the potential subsequence to validate
     * @return true if sequence is a valid subsequence of array, false otherwise
     * @throws IllegalArgumentException if either array or sequence is null
     * 
     *                                  Time Complexity: O(n) where n is the length
     *                                  of the array
     *                                  Space Complexity: O(1) as we only use two
     *                                  index variables
     */
    public static boolean isValidSubsequence(int[] array, int[] sequence) {
        // Validate inputs
        if (array == null || sequence == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }

        // Empty sequence is always a subsequence
        if (sequence.length == 0) {
            return true;
        }

        // If sequence is longer than array, it can't be a subsequence
        if (sequence.length > array.length) {
            return false;
        }

        int arrayIdx = 0, sequenceIdx = 0;

        // Iterate through both arrays
        while (sequenceIdx < sequence.length && arrayIdx < array.length) {
            // If current elements match, move to next sequence element
            if (array[arrayIdx] == sequence[sequenceIdx]) {
                sequenceIdx++;
            }
            // Always move to next array element regardless of match
            arrayIdx++;
        }

        // If we've gone through all sequence elements, it's a valid subsequence
        return sequenceIdx == sequence.length;
    }
}
