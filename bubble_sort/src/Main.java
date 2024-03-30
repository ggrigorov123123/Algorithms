import java.util.Arrays;

// Simplest sorting algorithm
// Not suitable for large data sets
//
// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
// It is stable
public class Main {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 2 , 6, 1};
        optimizedBubbleSort(arr);
        Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));
    }

    //TODO: compare both algorithms
    private static void optimizedBubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) break;
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}