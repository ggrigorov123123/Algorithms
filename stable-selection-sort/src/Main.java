import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 4a, 5, 3, 2, 4b, 1
        //
        // First minimum element is 1, now instead
        // of swapping. Insert 1 in its correct place
        // and pushing every element one step forward
        // 1, 4a, 5, 3, 2, 4b
        //
        // Next minimum is 2
        // 1, 2, 4a, 5, 3, 4b
        //
        // Next minimum is 3 :
        // 1, 2, 3, 4a, 5, 4b
        //
        // Repeat the steps until array is sorted.
        // 1, 2, 3, 4a, 4b, 5
        int[] arr = { 4, 5, 3, 2, 4, 1 };
        Arrays.stream(arr).forEach(a -> System.out.printf(" %d", a));
        System.out.println();
        stableSelectionSort(arr);
        Arrays.stream(arr).forEach(a -> System.out.printf(" %d", a));
    }

    // A sorting algorithm is said to be stable if two objects with equal or same keys appear in the same
    // order in sorted output as they appear in the input array to be sorted.
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1) (no extra arr is used)
    public static void stableSelectionSort(int[] arr){
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int key = arr[min];

            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }

            arr[i] = key;
        }
    }
}