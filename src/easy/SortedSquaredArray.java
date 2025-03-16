package easy;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] array = { -7, -5, -3, -1, 2, 4, 6 };
        System.out.println(Arrays.toString(getSquaredSortedArray(array)));
    }

    private static int[] getSquaredSortedArray(int[] array) {
        int[] squaredArray = new int[array.length];
        int leftIdx = 0, rightIdx = array.length - 1, squaredArrayIdx = squaredArray.length - 1;
        ;
        while (leftIdx != rightIdx) {
            if (Math.abs(array[rightIdx]) > Math.abs(array[leftIdx])) {
                squaredArray[squaredArrayIdx] = (int) Math.pow(array[rightIdx], 2);
                rightIdx--;
            } else {
                squaredArray[squaredArrayIdx] = (int) Math.pow(array[leftIdx], 2);
                leftIdx++;
            }
            squaredArrayIdx--;
        }
        return squaredArray;

    }
}
