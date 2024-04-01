import java.util.Arrays;
import java.util.Random;

// Simplest sorting algorithm
// Not suitable for large data sets
//
// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
// It is stable
public class Main {
    public static void main(String[] args) {
        int[] arr = generateUnsortedIntegers(100000);
        int[] arrCopy = Arrays.copyOf(arr, arr.length);


        var startOptimizedSort = System.currentTimeMillis();
        optimizedBubbleSort(arr);
        var endOptimizedSort = System.currentTimeMillis() - startOptimizedSort;
        System.out.print("Result Optimized Sort: ");
        Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));
        System.out.println();


        var startSort = System.currentTimeMillis();
        bubbleSort(arrCopy);
        var endSort = System.currentTimeMillis() - startSort;
        System.out.print("Result Normal Sort: ");
        Arrays.stream(arrCopy).forEach(e -> System.out.printf("%d ", e));
        System.out.println();

        System.out.println("------------------------------------------");
        System.out.printf("Optimized Time: %d ms\n", endOptimizedSort);
        System.out.printf("Normal Time: %d ms\n", endSort);
        System.out.println("------------------------------------------");


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

    private static int[] generateUnsortedIntegers(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}