public class QuickSort {

    // Method to perform quicksort on the array
    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high); // Find partition index
            quicksort(arr, low, p - 1); // Sort elements before partition
            quicksort(arr, p + 1, high); // Sort elements after partition
        }
    }

    // Method to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Method to find the partition position
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose the pivot element
        int left = low + 1;
        int right = high;

        while (left <= right) {
            // Move the left index to the right as long as elements are smaller than the pivot
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            // Move the right index to the left as long as elements are greater than the pivot
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            // Swap elements to ensure smaller elements are on the left and larger on the right
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // Place the pivot element in its correct position
        swap(arr, low, right);
        return right; // Return the partition index
    }

    // Method to print the array
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println("Unsorted Array:");
        printArray(arr); // Print the unsorted array
        // Sorting the whole array using quicksort
        quicksort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array:");
        printArray(arr); // Print the sorted array
    }
}

