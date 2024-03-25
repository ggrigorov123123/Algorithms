import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        Arrays.stream(arr).forEach(a -> System.out.printf(" %d", a));
        insertionSort(arr);
        System.out.println();
        Arrays.stream(arr).forEach(a -> System.out.printf(" %d", a));
    }

    // Time Complexity: O(N^2)
    // Auxiliary Space: 1
    // Efficient for small data values
    // Insertion sort is adaptive in nature, i.e. it is appropriate for data sets that are already partially sorted
    // It is stable
    // The array is virtually split into a sorted and an unsorted part
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}