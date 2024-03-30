import java.util.Arrays;

// The key process in quickSort is a partition(). The target of partitions is to place the pivot (any element can be
// chosen to be a pivot) at its correct position in the sorted array and put all smaller elements to the left of the
// pivot, and all greater elements to the right of the pivot.
//
// Partition is done recursively on each side of the pivot after the pivot is placed in its correct position and this
// finally sorts the array.
//
// Best/Average Case: θ(n*log(n))
// Worst Case: O(n^2) -> occurs when the pivot at each step consistently results in highly unbalanced partitions
// Merge Sort also have O(n*log(n)) time complexity, but Quick Sort is considered faster because of the constants we are omitting
// Auxiliary Space: O(1)
//
// Efficient for large data sets
// Not stable
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);

        for( int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}