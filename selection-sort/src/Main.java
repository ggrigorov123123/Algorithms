import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 3, 2, 1};
        selectionSort(arr);
        Arrays.stream(arr).forEach(a -> System.out.printf(" %d", a));
    }

    //Time Complexity: O(N * N)
    //Auxiliary Space: O(1) as the only extra memory used is for temp vars while swapping two values in arr.
    //It never makes more than O(N) swaps and can be useful when memory writing is costly.
    //Repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it with the first element of the unsorted part.
    //Does not preserve the relative order of items with equal keys which means it is not stable (There is stable impl -> Stable Selection Sort).
    //It is considered in-place algorithm (It does not require extra space)
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        //One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {

            //Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            //Swap the found minimum element with the first element of the unsorted array
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}