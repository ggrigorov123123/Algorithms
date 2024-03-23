import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int i = 7;

        System.out.printf("Index of %d in [ %s ] is: %d", i, Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")), binarySearch(arr, i));
    }

    public static int binarySearch(int[] arr, int i) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (arr[mid] == i) return mid;

            if (arr[mid] > i) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }
}