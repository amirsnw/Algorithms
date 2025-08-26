package mergeSortedArraysSingleTraversalInplace;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] array1 = {-3, 5, 4, 0, 0, 0};
        int[] array2 = {1, 3, 6};

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        new Solution().merge(array1, 3, array2, 3);
        System.out.println("Merged result: " + Arrays.toString(array1));

        array1 = new int[]{-3, 1, 6, 0, 0, 0};
        array2 = new int[]{3, 4, 5};

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        new Solution().merge(array1, 3, array2, 3);
        System.out.println("Merged result: " + Arrays.toString(array1));
    }
}
